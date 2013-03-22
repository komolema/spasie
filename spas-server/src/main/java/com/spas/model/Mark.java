/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author 207163413
 */
@Entity
public class Mark implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //attributes
    private double actualMark;
  

    //relationships
    @ManyToOne
    private Assessment assesment;
    @ManyToOne
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.Mark[id=" + id + "]";
    }

    /**
     * @return the ActualMark
     */
    public double getActualMark() {
        return actualMark;
    }

    /**
     * @param actualMark the actualMark to set
     */
    public void setActualMark(double actualMark) {
        this.actualMark = actualMark;
    }

    /**
     * @return the TotalMark
     */
   

    /**
     * @return the assessment
     */
    public Assessment getAssesment() {
        return assesment;
    }

    /**
     * @param assessment the assessment to set
     */
    public void setAssesment(Assessment assesment) {
        this.assesment = assesment;
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

}
