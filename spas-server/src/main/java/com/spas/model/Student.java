/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 207163413
 */
@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String num;

    //attributes
    private String Name;
    private String Surname;
    private String Cell;
    private String Email;
    private String Type;
    private String OfferingType;
    private String Campus;

    @OneToMany(mappedBy = "student")
    private List<Fact> facts;
    
    @ManyToOne
    private Course course;

    

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
   private List<Mark> mark;
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (num != null ? num.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.Student[num=" + num + "]";
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * @param Surname the Surname to set
     */
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    /**
     * @return the Cell
     */
    public String getCell() {
        return Cell;
    }

    /**
     * @param Cell the Cell to set
     */
    public void setCell(String Cell) {
        this.Cell = Cell;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the subjects
     */
 

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
     * @return the mark
     */
    public List<Mark> getMark() {
        return mark;
    }

    /**
     * @param mark the mark to set
     */
    public void setMark(List<Mark> mark) {
        this.mark = mark;
    }

    /**
     * @return the Type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * @return the facts
     */
    public List<Fact> getFacts() {
        return facts;
    }

    /**
     * @param facts the facts to set
     */
    public void setFacts(List<Fact> facts) {
        this.facts = facts;
    }

    /**
     * @return the OfferingType
     */
    public String getOfferingType() {
        return OfferingType;
    }

    /**
     * @param OfferingType the OfferingType to set
     */
    public void setOfferingType(String OfferingType) {
        this.OfferingType = OfferingType;
    }

    /**
     * @return the Campus
     */
    public String getCampus() {
        return Campus;
    }

    /**
     * @param Campus the Campus to set
     */
    public void setCampus(String Campus) {
        this.Campus = Campus;
    }

    

}
