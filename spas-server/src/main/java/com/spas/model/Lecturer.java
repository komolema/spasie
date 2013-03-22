/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 207163413
 */
@Entity
public class Lecturer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String num;

      //attributes
    private String Title;
    private String Name;
    private String Initials;
    private String Surname;
    private String Cell;
    private String Email;

    @OneToMany(mappedBy = "lecturer")
    private List<Fact> facts;
    
    @ManyToOne
    private Faculty faculty;

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
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.Lecturer[id=" + num + "]";
    }

    /**
     * @param num the num to set
     */
   

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
     * @return the faculty
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
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
     * @return the Initials
     */
    public String getInitials() {
        return Initials;
    }

    /**
     * @param Initials the Initials to set
     */
    public void setInitials(String Initials) {
        this.Initials = Initials;
    }

}
