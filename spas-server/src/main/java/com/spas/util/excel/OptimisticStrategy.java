/*
 * This class implements a optimistic approach to persisiting the data from the
 * ExcelInfo class to the database, it creates everything that is not already
 * available from the excel file i.e if a university,faculty,lecturer,subject or
 * course objects do not exist they will be created automatically
 */

package com.spas.util.excel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spas.model.Assessment;
import com.spas.model.Fact;
import com.spas.model.Mark;
import com.spas.model.University;
import com.spas.services.*;

import java.util.List;

/**
 *
 * @author Dada
 */
public class OptimisticStrategy  extends ExcelStrategy{

    private ExcelInfo ei;
    private List<Fact> facts;
    private UniversityServices universityService;
    private StudentService studentService;
    private FactService factService;
    private FacultyServices facultyService;
    private MarkServices markService;
    private CourseServices courseService;
    private SubjectService subjectService;
    private ClassGroupService cgService;
    private LecturerService lecturerService;
    private AssessmentServices assessmentService;
    private ApplicationContext ctx;

    public OptimisticStrategy()
    {
         ctx = new ClassPathXmlApplicationContext("classpath:za/ac/cput/spas/conf/applicationContext.xml");
         universityService = (UniversityServices) ctx.getBean("universityService");
         studentService = (StudentService) ctx.getBean("studentService");
         facultyService = (FacultyServices) ctx.getBean("facultyService");
         cgService = (ClassGroupService) ctx.getBean("cgService");
         subjectService = (SubjectService) ctx.getBean("subjectService");
         courseService = (CourseServices) ctx.getBean("courseService");
         factService = (FactService) ctx.getBean("factService");
         markService = (MarkServices) ctx.getBean("markService");
         lecturerService = (LecturerService) ctx.getBean("lecturerService");
         assessmentService = (AssessmentServices) ctx.getBean("assessmentService");
    }

    @Override
    public void persistToDatabase(ExcelInfo ei) {

        this.ei = ei;

        //call the restorer
        //call the persister
        persistPA();
    }

    private void buildAllRelations() {

        //variables
        /*Faculty tmpFac;
        Lecturer tmpLec;
        
        Course tmpCourse;
        Subject tmpSubject;
        Student tmpStudent;*/
        Fact    tmpFact;

        //build & persist university
        University capeTech = new University();

        //load university if it already exists
        try{
            capeTech.setCode("cput");
            capeTech.setName("Cape Penninsula University of Technology");
            universityService.add(capeTech);
        }
        catch(Exception ex)
        {
            capeTech = universityService.get("cput");
        }
        
        

        //build & persist faculty
       try{
           ei.getFaculty().setUniversity(capeTech);
           facultyService.add(ei.getFaculty());
       }
       catch(Exception ex)
       {
           ei.setFaculty(facultyService.get(ei.getFaculty().getCode()));     
           ei.getFaculty().setUniversity(capeTech);
       }

       
        
     
        //build & persist course
        try{
            ei.getCourse().setFaculty(ei.getFaculty());
            courseService.add(ei.getCourse());
        }
        catch(Exception ex)
        {
            ei.setCourse(courseService.get(ei.getCourse().getCode()));
            ei.getCourse().setFaculty(ei.getFaculty());
        }


        //build & persist subject
        try{
            ei.getSubject().setCourse(ei.getCourse());
            subjectService.add(ei.getSubject());
        }
        catch(Exception ex)
        {
            ei.setSubject(subjectService.get(ei.getSubject().getCode()));
            ei.getSubject().setCourse(ei.getCourse());
        }
        

        //build & persist lecturer
        try
        {
            ei.getLecturer().setFaculty(ei.getFaculty());
            lecturerService.add(ei.getLecturer());
        }
        catch(Exception ex)
        {
            ei.setLecturer(lecturerService.get(ei.getLecturer().getNum()));
            ei.getLecturer().setFaculty(ei.getFaculty());
        }
        //build & persist classgroup
        try
        {
            cgService.add(ei.getCg());
        }
        catch(Exception ex)
        {
            ei.setCg(cgService.get(ei.getCg().getCode()));
        }


         //persist the marks
        /*
        for (int j = 0; j != ei.getMarks().size(); j++) // j = row
        {
            for (int k = 0; k != ei.getMarks().get(j).size(); k++) // k = column
            {


                markService.newMark(ei.getMarks().get(j).get(k));

            }
        }*/


        //build & persist assessments
        //and attach to marks
        List<Assessment> assList = null;
        assList = assessmentService.getAllByProperty("subject.code",ei.getSubject().getCode());
        boolean assFound = false;
        List<List<Mark>> aMarks = null;
        for(int i=0;i!=ei.getAssesments().size();i++)
        {
            //check if there is already an assesment for that subject
            //if there is one reload it from the database
            if(assList != null)
            {
                // search for that particular assignment
                //by assignment name
                assFound = false;
                for(int a=0;a!=assList.size();a++)
                {
                    //if that particular assignment exists
                    //load from disk
                    if(assList.get(a).getName().equals(ei.getAssesments().get(i).getName())) // check if the names match
                    {
                       ei.getAssesments().set(i,assList.get(a));
                       assFound = true;
                    }
                }
                if(assFound == false)
                {
                   ei.getAssesments().get(i).setSubject(ei.getSubject());
                   assessmentService.add(ei.getAssesments().get(i));
                }
            }
            else
            {
                ei.getAssesments().get(i).setSubject(ei.getSubject());
                assessmentService.add(ei.getAssesments().get(i));

            }
            //attach assessment to marks
            
            for(int j=0;j!=ei.getMarks().size();j++) // j = row
            {
                for(int k=0;k!=ei.getMarks().get(j).size();k++) // k = column
                {
                    if(k == i)
                    {
                        //delete marks that are related to [i] particular assessment
                        if(assFound == true)
                        {
                            List<Mark> tmpM = ei.getAssesments().get(i).getMarks();
                            for(Mark tm : tmpM){
                                markService.delete(tm);
                            }
                        }
                        //link marks to assessment
                        ei.getMarks().get(j).get(k).setAssesment(ei.getAssesments().get(i));
                      
                    }
                }
            }
        }
        //build & persist student
        for(int i=0;i!=ei.getStudents().size();i++)
        {
             //build & persist the marks

           
            
            
            ei.getStudents().get(i).setCourse(ei.getCourse());
         
            studentService.update(ei.getStudents().get(i));

            for(int j=0;j!=ei.getMarks().get(i).size();j++)
            {
                ei.getMarks().get(i).get(j).setStudent(ei.getStudents().get(i));
                markService.add(ei.getMarks().get(i).get(j));
            }

            //build & persist the fact
            try{
                tmpFact = new Fact();
                tmpFact.setClassGroup(ei.getCg());
                tmpFact.setLecturer(ei.getLecturer());
                tmpFact.setSubject(ei.getSubject());
                tmpFact.setStudent(ei.getStudents().get(i));
                tmpFact.setCalendarYear(ei.getCalendarYear());
                tmpFact.setCancelDate(ei.getcDateList().get(i));
                factService.add(tmpFact);

            }
            catch(Exception ex)
            {
                
            }
            
        }

       
    }

    void persistPA()
    {
        //build the relations
        buildAllRelations();
/*
        //create a default university
        University capeTech = new University();
        capeTech.setName("Cape Penninsula University of Technology");

        List<Faculty> facList = new ArrayList();
        facList.add(ei.getFaculty());
        capeTech.setFaculty(facList);
        //persist to the database
        universityService.UpdateUniversity(capeTech);
        for(int i=0;i!=facts.size();i++){
            factService.addFact(facts.get(i));
        }
*/
    }

}
