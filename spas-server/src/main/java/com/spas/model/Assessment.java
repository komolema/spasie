/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import com.spas.model.Mark;
import com.spas.model.Subject;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 207163413
 */
@Entity
public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //attributes
    private String name;
    private double Weight;


    @ManyToOne
    private Subject subject;

    @OneToMany(cascade = CascadeType.ALL)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Mark> marks;

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
        if (!(object instanceof Assessment)) {
            return false;
        }
        Assessment other = (Assessment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.Assessment[id=" + id + "]";
    }

    /**
     * @return the Type
     */
    public String getName() {
        return name;
    }

    /**
     * @param Type the Type to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Weight
     */
    public double getWeight() {
        return Weight;
    }

    /**
     * @param Weight the Weight to set
     */
    public void setWeight(double Weight) {
        this.Weight = Weight;
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
     * @return the marks
     */
    public List<Mark> getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }



}
