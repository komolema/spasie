/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import com.spas.model.Assessment;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 207163413
 */
@Entity
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String code;


      //attributes
    private String Name;
    private int SubjectLevel;

    @OneToMany(mappedBy = "subject")
    private List<Fact> facts;
    
    @OneToMany(cascade= CascadeType.ALL)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Assessment> assesments;
    
    @ManyToOne
    private Course course;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.Subject[code=" + code + "]";
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
     * @return the assesments
     */
    public List<Assessment> getAssesments() {
        return assesments;
    }

    /**
     * @param assesments the assesments to set
     */
    public void setAssesments(List<Assessment> assesments) {
        this.assesments = assesments;
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
     * @return the SubjectLevel
     */
    public int getSubjectLevel() {
        return SubjectLevel;
    }

    /**
     * @param SubjectLevel the SubjectLevel to set
     */
    public void setSubjectLevel(int SubjectLevel) {
        this.SubjectLevel = SubjectLevel;
    }

}
