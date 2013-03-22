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
public class Faculty implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    private String code;
    private String name;

    //relationships
    @OneToMany(cascade= CascadeType.ALL,mappedBy="faculty")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Course> courses;

    @ManyToOne
    private University university;

    @OneToMany(cascade = CascadeType.ALL)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Lecturer> lecturers;

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
        // TODO: Warning - this method won't work in the case the code fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.Faculty[code=" + code + "]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * @return the university
     */
    public University getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(University university) {
        this.university = university;
    }

    /**
     * @return the lecturers
     */
    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    /**
     * @param lecturers the lecturers to set
     */
    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

}
