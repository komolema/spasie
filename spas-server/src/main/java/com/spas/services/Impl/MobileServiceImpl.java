/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.*;
import com.spas.security.Login;
import com.spas.security.SpasCustomAuthenticationProcessor;
import com.spas.services.*;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author Z
 */
@WebService(endpointInterface = "com.spas.services.MobileService")
public class MobileServiceImpl implements MobileService{

    private AssessmentServices assessmentService;
    private SubjectService subjectService;
    private MarkServices  markService;
    private StudentService studentService;

    private Map<String,String> users;
    public String authenticateStudent(String username, String password) {
       SpasCustomAuthenticationProcessor sProcessor = new SpasCustomAuthenticationProcessor();
       Login l = new Login();
       l.setType(Login.NOVELLLDAP_STUDENT_MAIN);
       l.setUserSupName(username);
       l.setUserSupPassword(password);

       sProcessor.doAuthentication(l);

       if(l.isAuthennticated())
       {
           String sessionID = UUID.randomUUID().toString();

           users.put(sessionID,l.getUserSupName());

           return sessionID;
       }
       return "no";

    }



    public String sayHello() {
        return new String("hello");
    }

    public List<Subject> getSubjects(String sessionID) {
        List<Subject> subjects = new ArrayList<Subject>();

        if(isLoggedIn(sessionID)){
             String stu_code = users.get(sessionID);
            Student student;

            try
            {
                student = studentService.get(stu_code);
                List<Fact> facts = student.getFacts();

                for(int i=0;i!=facts.size();i++)
                {
                    subjects.add(facts.get(i).getSubject());
                }
            }
            catch(Exception ex)
            {
            
            }
        }


        return subjects;

    }

    public List<Assessment> getAssessment(String sessionID, String subjectCode) {
        List<Assessment> assessments = new ArrayList<Assessment>();

        if(isLoggedIn(sessionID))
        {
           try
            {
                assessments = assessmentService.getAllByProperty("subject.code", subjectCode);
            }
            catch(Exception ex)
            {

            }
        }

        return assessments;
    }

    public List<Mark> getMarks(String sessionID, Long assessmentID) {
        List<Mark> marks = new ArrayList<Mark>();
        Student student;
        if(isLoggedIn(sessionID))
        {
            try
            {
                student = studentService.get(users.get(sessionID));
                List<Mark> tmpMarks = student.getMark();
                for(int i=0;i!=tmpMarks.size();i++)
                {
                    if((tmpMarks.get(i).getAssesment().getId()) == assessmentID)
                    {
                        marks.add(tmpMarks.get(i));
                    }
                }
            }
            catch(Exception ex)
            {

            }
        }
        return marks;
    }

    public boolean logout(String sessionID) {
        try{
            users.remove(sessionID);
        }
        catch(Exception ex)
        {

        }

        return true;
    }
    public boolean isLoggedIn(String sessionID)
    {
        return users.containsKey(sessionID);
    }
}
