/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.util.excel;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import com.spas.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Dada
 */
public class ExcelInfo implements Serializable {



    private ExcelFormat ef;
    private ExcelLoc loc;

    private int numStudents;
    private int numTests;
    
    private String campus;
    private String offeringType;
    //to be used for the fact table
    private int calendarYear;
    private ArrayList<String> cDateList;

    private Faculty  faculty;
    private Course   course;
    private Lecturer lecturer;
    private Subject  subject;
    private ArrayList<Student> students;
    private ArrayList<ArrayList<Mark>> marks;
    private ArrayList<Assessment> assesments;
    private ClassGroup      cg;
    
    /*JExcel*/
    private Workbook workbook;
    private Sheet   sheet;
    private Cell    cell;

    private InputStream     xStream;

    /*Constructors*/
    public ExcelInfo(){
        xStream = null;
        ef = null;
    }
    public ExcelInfo(InputStream io)throws IOException,Exception{

        this.xStream = io;
        ef = new DefaultExcelFormat();

        init();
    }
    ExcelInfo(InputStream io,ExcelFormat ef)throws IOException,Exception{
        
        this.xStream = io;
        this.ef = ef;

        init();
    }

    /*Private methods*/

    //initialization method
    private void init() throws IOException, Exception{



        //initialiaze the ExcelInfo class
        loc = ef.createLoc();

        //initialiaze Jakatra POI
        workbook = Workbook.getWorkbook(xStream);
        sheet = workbook.getSheet(0);
        if(sheet == null){
            throw new Exception("Sheet does not exist");
        }

        //validate the excel document
        DefaultExcelFormatValidator defv = new DefaultExcelFormatValidator();
        defv.validate(sheet);

        /*Build object from excel file*/

        initStats();

        buildFaculty(loc.getFacultyLoc());
        buildCourse(loc.getCourseCodeLoc());
        buildLecturer(loc.getLecturerLoc()); 
        buildSubject(loc.getSubCodeLoc());
        buildStudents(loc.getStudentNoLoc());
        buildAssesment();
        buildClassGroup(loc.getClassCodeLoc());
        buildMarks();

    }

    //method takes a cell as a parameter and returns a cell
    private Cell getCell(int row,int column)
    {
        
        Cell tmpCell= sheet.getCell(column,row);
        return tmpCell;
    }

    private Cell getCell(ExcelCell cLoc)
    {
        return getCell(cLoc.getRow(),cLoc.getColumn());
    }


    //method takes a cell location to the lecturer details
    //and tries to load the lecturer details
    //if there lecturer does not exist an exception is thrown
    private void buildLecturer(ExcelCell cLoc)
    {
        cell = getCell(cLoc);

        lecturer = new Lecturer();

        String strContents = cell.getContents();
        String strNum ="";
        String strTitle ="";
        String strInitials = "";
        String strSurname="";

        //perform split
        String[] strSplit = strContents.split("\\s");
        strNum = strSplit[0];
        strTitle = strSplit[1];
        strInitials = strSplit[2];
        strSurname = strSplit[3];

        lecturer.setNum(strNum);
        lecturer.setTitle(strTitle);
        lecturer.setInitials(strInitials);
        lecturer.setSurname(strSurname);

    }

    //method takes a cell location to the faculty details
    //and tries to load the lecturer details
    //if the faculty does not exist an exception is thrown
    private void buildFaculty(ExcelCell cLoc)
    {
        cell=getCell(cLoc);

        faculty = new Faculty();

        faculty.setCode(cell.getContents());

        cell = getCell(loc.getCourseNameLoc());

        faculty.setName(cell.getContents());

    }

    //method takes a cell location to the subject details
    //and tries to load the lecturer details
    //if the faculty does not exist an exception is thrown
    private void buildSubject(ExcelCell cLoc)
    {
        cell=getCell(cLoc);

        subject = new Subject();

        subject.setCode(cell.getContents());
        subject.setName(getCell(loc.getSubNameLoc()).getContents());
    }

    //method takes a cell location to the subject details
    //and tries to load the lecturer details
    //if the faculty does not exist an exception is thrown
    private void buildStudents(ExcelCell cLoc)
    {
        //Variables
        Student stu;
        students = new ArrayList<Student>();
        cDateList = new ArrayList<String>();
        int stuColumn = cLoc.getColumn();
        int cDateColumn = loc.getCancelLoc().getColumn();
        int beginRow = cLoc.getRow();
        int lastRow  = beginRow + numStudents;
        //String stuNum = null;
        Cell tmpCell;
        StringTokenizer token;
        String number;
        String email;
        String cdate;
        while(beginRow != lastRow)
        {
            String studName = "";

            tmpCell = getCell(beginRow,stuColumn);
            stu = new Student();
            stu.setNum(tmpCell.getContents());
            email = tmpCell.getContents()+"@cput.ac.za";
            stu.setEmail(email);
            stu.setCampus(campus);
            stu.setOfferingType(offeringType);
            tmpCell = getCell(beginRow,stuColumn-1);
            token = new StringTokenizer(tmpCell.getContents(), "-");

            number = token.nextToken();
            while(token.hasMoreTokens())
            {
               studName = token.nextToken();
            }
            stu.setName(studName);

            students.add(stu);

            //initialize the cancel dates
            tmpCell = getCell(beginRow,cDateColumn);
            cdate =(tmpCell.getType() == CellType.EMPTY) ? "N":tmpCell.getContents();
            cDateList.add(cdate);
            beginRow++;
        }

        //build the student object
        //attach to subject object
        //build the assessment objects
        //attach to subject object
        //build the marks objects
    }

        //method initialiazes the numStudents and numTests variables
    private void initStats() {

        //init the numStudents
       
        cell = getCell(loc.getNumStudentLoc().getRow(),loc.getNumStudentLoc().getColumn());

        
        numStudents = Integer.parseInt(cell.getContents());

        //init the numTests
       
        cell = getCell(loc.getNumTestLoc().getRow(),loc.getNumTestLoc().getColumn());

        numTests = Integer.parseInt(cell.getContents());

        //init the calendar year

        cell = getCell(loc.getYearLoc());

        calendarYear = Integer.parseInt(cell.getContents());

        //init the campus type
        cell = getCell(loc.getCampusLoc());
        String strCampus = cell.getContents();
        String[] strFirst = strCampus.split("\\s",2);
        campus = strFirst[1];

        //init the offering type
        cell = getCell(loc.getOfferingTypeLoc());
        offeringType = cell.getContents();
    }

    private void buildCourse(ExcelCell cLoc) {
        cell = getCell(cLoc);

        course = new Course();

        course.setCode(cell.getContents());
        cell = getCell(loc.getCourseNameLoc());
        course.setName(cell.getContents());
        


    }

    private void buildAssesment() {
        cell = getCell(loc.getTestNameLoc());

        Assessment ass;
        assesments = new ArrayList<Assessment>();

        int beginColumn = loc.getTestNameLoc().getColumn();
        int lastColumn  = beginColumn + numTests;
        int assRow      = loc.getTestNameLoc().getRow();
        int weightRow   = loc.getTestWeightLoc().getRow();

        Cell tmpCell;

        while(beginColumn != lastColumn)
        {
           // get the assessment type
           tmpCell = getCell(assRow,beginColumn);
           ass = new Assessment();
           ass.setName(tmpCell.getContents());

           //get the assesment weight
           tmpCell = getCell(weightRow,beginColumn);
           ass.setWeight(Integer.parseInt(tmpCell.getContents()));

           assesments.add(ass);

           beginColumn++;
        }
    }

    private void buildMarks()
    {

        //variables
        int beginStudentRow = loc.getStudentNoLoc().getRow();
        int lastStudentRow  = beginStudentRow + numStudents;
        int markRow = loc.getMarkLoc().getRow();
        int beginMarkColumn = loc.getMarkLoc().getColumn();
        int lastMarkColumn =  beginMarkColumn + numTests;

        Cell tmpCell;

        ArrayList<Mark> tmpMarkList;
        Mark tmpMark;
        //initialiaze the marks 2d-list
        marks = new ArrayList<ArrayList<Mark>>();

        //traverse thru all the students and add their marks
        while(beginStudentRow != lastStudentRow)
        {
            //get all the student's marks
            //create a new marks list
            tmpMarkList = new ArrayList<Mark>();

            while(beginMarkColumn != lastMarkColumn)
            {
                //get the value from the cell
                tmpCell = getCell(beginStudentRow,beginMarkColumn);
                 tmpMark = new Mark();
                if ((tmpCell.getType()) != CellType.EMPTY) {
                    //create a new mark object                   
                    tmpMark.setActualMark(Double.parseDouble(tmpCell.getContents()));

                    tmpMarkList.add(tmpMark);
                }
                else
                {
                    tmpMark.setActualMark(-1);
                    tmpMarkList.add(tmpMark);
                }


                beginMarkColumn++;
            }
            //save the student's mark for the particular row that the loop is in
            marks.add(tmpMarkList);

            //reset the value of the column back to it's normal state
            beginMarkColumn = loc.getMarkLoc().getColumn();

            beginStudentRow++;
        }

    }

    private void buildClassGroup(ExcelCell cLoc) {
        cell = getCell(cLoc);

        cg = new ClassGroup();

        cg.setCode(cell.getContents());

    }



    /***Getters & Setters***/

    /**
     * @return the numStudents
     */
    public int getNumStudents() {
        return numStudents;
    }

    /**
     * @return the numTests
     */
    public int getNumTests() {
        return numTests;
    }

    /**
     * @return the lecturer
     */
    public Lecturer getLecturer() {
        return lecturer;
    }

    /**
     * @param lecturer the lecturer to set
     */
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the faculty
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * @return the xStream
     */
    public InputStream getxStream() {
        return xStream;
    }

    /**
     * @param xStream the xStream to set
     */
    public void setxStream(InputStream xStream) {
        this.xStream = xStream;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @param students the students to set
     */
   
    /**
     * @return the assesments
     */
    public ArrayList<Assessment> getAssesments() {
        return assesments;
    }

    /**
     * @param assesments the assesments to set
     */
    public void setAssesments(ArrayList<Assessment> assesments) {
        this.assesments = assesments;
    }

    /**
     * @return the cg
     */
    public ClassGroup getCg() {
        return cg;
    }

    /**
     * @param cg the cg to set
     */
    public void setCg(ClassGroup cg) {
        this.cg = cg;
    }

    /**
     * @return the marks
     */
    public ArrayList<ArrayList<Mark>> getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(ArrayList<ArrayList<Mark>> marks) {
        this.marks = marks;
    }

    /**
     * @return the calendarYear
     */
    public int getCalendarYear() {
        return calendarYear;
    }

    /**
     * @param calendarYear the calendarYear to set
     */
    public void setCalendarYear(int calendarYear) {
        this.calendarYear = calendarYear;
    }

    /**
     * @return the cDateList
     */
    public ArrayList<String> getcDateList() {
        return cDateList;
    }

    /**
     * @param cDateList the cDateList to set
     */
    public void setcDateList(ArrayList<String> cDateList) {
        this.cDateList = cDateList;
    }

    /**
     * @return the campus
     */
    public String getCampus() {
        return campus;
    }

    /**
     * @param campus the campus to set
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }




}
