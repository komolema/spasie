/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 * @author Z
 */
@Embeddable
public class FactId implements Serializable{
    private int calendarYear;

    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Lecturer lecturer;
    @ManyToOne
    private Student student;
    @ManyToOne
    private ClassGroup classGroup;

    @Override
    public boolean equals(Object other)
    {
      if(other ==null){
          return false;
      }
      if(!(other instanceof FactId)){
          return false;
      }
      FactId that = (FactId) other;
      return ((this.calendarYear == that.calendarYear)&&(this.classGroup.equals(that.classGroup))
              &&(this.lecturer.equals(that.lecturer))&&(this.subject.equals(that.subject))
              &&(this.student.equals(that.student)));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.calendarYear;
        hash = 61 * hash + (this.subject != null ? this.subject.hashCode() : 0);
        hash = 61 * hash + (this.lecturer != null ? this.lecturer.hashCode() : 0);
        hash = 61 * hash + (this.student != null ? this.student.hashCode() : 0);
        hash = 61 * hash + (this.classGroup != null ? this.classGroup.hashCode() : 0);
        return hash;
    }
}

