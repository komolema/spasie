/*
 * The purpose of this class is to hold information about the location of the
 * data in the excel file it is used to get extract the data from the excel file
 * and build the enity classes
 */

package com.spas.util.excel;

/**
 *
 * @author 207163413
 */
public class ExcelLoc {

    /***Attributes***/

    //attribute locations
    private ExcelCell numTestLoc;
    private ExcelCell numStudentLoc;
    private ExcelCell subCodeLoc;
    private ExcelCell subNameLoc;
    private ExcelCell classCodeLoc;
    private ExcelCell lecturerLoc;
    private ExcelCell facultyLoc;
    private ExcelCell facultyNameLoc;
    
    //an array which contains the number of students in
    private ExcelCell studentNoLoc;
    private ExcelCell studentNameLoc;
    private ExcelCell courseCodeLoc;
    private ExcelCell courseNameLoc;

    private ExcelCell markLoc;
    private ExcelCell testWeightLoc;
    private ExcelCell testNameLoc;
    private ExcelCell offeringTypeLoc;
    private ExcelCell campusLoc;
    private ExcelCell yearLoc;
    private ExcelCell cancelLoc;
    //constructors
    public ExcelLoc(){}

 
    /**
     * @return the numTestLoc
     */
    public ExcelCell getNumTestLoc() {
        return numTestLoc;
    }

    /**
     * @param numTestLoc the numTestLoc to set
     */
    public void setNumTestLoc(ExcelCell numTestLoc) {
        this.numTestLoc = numTestLoc;
    }

    /**
     * @return the numStudentLoc
     */
    public ExcelCell getNumStudentLoc() {
        return numStudentLoc;
    }

    /**
     * @param numStudentLoc the numStudentLoc to set
     */
    public void setNumStudentLoc(ExcelCell numStudentLoc) {
        this.numStudentLoc = numStudentLoc;
    }

    /**
     * @return the subCodeLoc
     */
    public ExcelCell getSubCodeLoc() {
        return subCodeLoc;
    }

    /**
     * @param subCodeLoc the subCodeLoc to set
     */
    public void setSubCodeLoc(ExcelCell subCodeLoc) {
        this.subCodeLoc = subCodeLoc;
    }

    /**
     * @return the classCodeLoc
     */
    public ExcelCell getClassCodeLoc() {
        return classCodeLoc;
    }

    /**
     * @param classCodeLoc the classCodeLoc to set
     */
    public void setClassCodeLoc(ExcelCell classCodeLoc) {
        this.classCodeLoc = classCodeLoc;
    }

    /**
     * @return the lecturerLoc
     */
    public ExcelCell getLecturerLoc() {
        return lecturerLoc;
    }

    /**
     * @param lecturerLoc the lecturerLoc to set
     */
    public void setLecturerLoc(ExcelCell lecturerLoc) {
        this.lecturerLoc = lecturerLoc;
    }

    /**
     * @return the studentNoLoc
     */
    public ExcelCell getStudentNoLoc() {
        return studentNoLoc;
    }

    /**
     * @param studentNoLoc the studentNoLoc to set
     */
    public void setStudentNoLoc(ExcelCell studentNoLoc) {
        this.studentNoLoc = studentNoLoc;
    }

    /**
     * @return the studentNameLoc
     */
    public ExcelCell getStudentNameLoc() {
        return studentNameLoc;
    }

    /**
     * @param studentNameLoc the studentNameLoc to set
     */
    public void setStudentNameLoc(ExcelCell studentNameLoc) {
        this.studentNameLoc = studentNameLoc;
    }

    /**
     * @return the courseCodeLoc
     */
    public ExcelCell getCourseCodeLoc() {
        return courseCodeLoc;
    }

    /**
     * @param courseCodeLoc the courseCodeLoc to set
     */
    public void setCourseCodeLoc(ExcelCell courseCodeLoc) {
        this.courseCodeLoc = courseCodeLoc;
    }

    /**
     * @return the markLoc
     */
    public ExcelCell getMarkLoc() {
        return markLoc;
    }

    /**
     * @param markLoc the markLoc to set
     */
    public void setMarkLoc(ExcelCell markLoc) {
        this.markLoc = markLoc;
    }

    /**
     * @return the testWeightLoc
     */
    public ExcelCell getTestWeightLoc() {
        return testWeightLoc;
    }

    /**
     * @param testWeightLoc the testWeightLoc to set
     */
    public void setTestWeightLoc(ExcelCell testWeightLoc) {
        this.testWeightLoc = testWeightLoc;
    }

    /**
     * @return the testNameLoc
     */
    public ExcelCell getTestNameLoc() {
        return testNameLoc;
    }

    /**
     * @param testNameLoc the testNameLoc to set
     */
    public void setTestNameLoc(ExcelCell testNameLoc) {
        this.testNameLoc = testNameLoc;
    }

    /**
     * @return the facultyLoc
     */
    public ExcelCell getFacultyLoc() {
        return facultyLoc;
    }

    /**
     * @param facultyLoc the facultyLoc to set
     */
    public void setFacultyLoc(ExcelCell facultyLoc) {
        this.facultyLoc = facultyLoc;
    }

    /**
     * @return the courseNameLoc
     */
    public ExcelCell getCourseNameLoc() {
        return courseNameLoc;
    }

    /**
     * @param courseNameLoc the courseNameLoc to set
     */
    public void setCourseNameLoc(ExcelCell courseNameLoc) {
        this.courseNameLoc = courseNameLoc;
    }

    /**
     * @return the subNameLoc
     */
    public ExcelCell getSubNameLoc() {
        return subNameLoc;
    }

    /**
     * @param subNameLoc the subNameLoc to set
     */
    public void setSubNameLoc(ExcelCell subNameLoc) {
        this.subNameLoc = subNameLoc;
    }

    /**
     * @return the offeringTypeLoc
     */
    public ExcelCell getOfferingTypeLoc() {
        return offeringTypeLoc;
    }

    /**
     * @param offeringTypeLoc the offeringTypeLoc to set
     */
    public void setOfferingTypeLoc(ExcelCell offeringTypeLoc) {
        this.offeringTypeLoc = offeringTypeLoc;
    }

    /**
     * @return the campusLoc
     */
    public ExcelCell getCampusLoc() {
        return campusLoc;
    }

    /**
     * @param campusLoc the campusLoc to set
     */
    public void setCampusLoc(ExcelCell campusLoc) {
        this.campusLoc = campusLoc;
    }

    /**
     * @return the yearLoc
     */
    public ExcelCell getYearLoc() {
        return yearLoc;
    }

    /**
     * @param yearLoc the yearLoc to set
     */
    public void setYearLoc(ExcelCell yearLoc) {
        this.yearLoc = yearLoc;
    }

    /**
     * @return the cancelLoc
     */
    public ExcelCell getCancelLoc() {
        return cancelLoc;
    }

    /**
     * @param cancelLoc the cancelLoc to set
     */
    public void setCancelLoc(ExcelCell cancelLoc) {
        this.cancelLoc = cancelLoc;
    }

    /**
     * @return the facultyNameLoc
     */
    public ExcelCell getFacultyNameLoc() {
        return facultyNameLoc;
    }

    /**
     * @param facultyNameLoc the facultyNameLoc to set
     */
    public void setFacultyNameLoc(ExcelCell facultyNameLoc) {
        this.facultyNameLoc = facultyNameLoc;
    }

}
