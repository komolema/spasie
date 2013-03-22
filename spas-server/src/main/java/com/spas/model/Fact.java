/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author komolema
 */
@Entity
@IdClass(FactId.class)
public class Fact implements Serializable {

    //Relationships & Id
    @Id
    private int calendarYear;

    @Id
    @ManyToOne
    private Subject subject;

    @Id
    @ManyToOne
    private Student student;

    @Id
    @ManyToOne
    private Lecturer lecturer;

    @Id
    @ManyToOne
    private ClassGroup classGroup;

    private static final long serialVersionUID = 1L;
  

    
    //attributes
    
    private String cancelDate;

 


    @Override
    public boolean equals(Object other) {
         if(other ==null){
          return false;
      }
      if(!(other instanceof Fact)){
          return false;
      }
      Fact that = (Fact) other;
      return ((this.calendarYear == that.calendarYear)&&(this.classGroup.equals(that.classGroup))
              &&(this.lecturer.equals(that.lecturer))&&(this.subject.equals(that.subject))
              &&(this.student.equals(that.student)));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.calendarYear;
        hash = 79 * hash + (this.subject != null ? this.subject.hashCode() : 0);
        hash = 79 * hash + (this.student != null ? this.student.hashCode() : 0);
        hash = 79 * hash + (this.lecturer != null ? this.lecturer.hashCode() : 0);
        hash = 79 * hash + (this.classGroup != null ? this.classGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.Fact[id= ]";
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
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
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
     * @return the classGroup
     */
    public ClassGroup getClassGroup() {
        return classGroup;
    }

    /**
     * @param classGroup the classGroup to set
     */
    public void setClassGroup(ClassGroup classGroup) {
        this.classGroup = classGroup;
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
     * @return the cancelDate
     */

    public String getCancelDate() {
        return cancelDate;
    }

    /**
     * @param cancelDate the cancelDate to set
     */

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

   
}
