/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 207163413
 */
@Entity
public class ClassGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String code;

    @OneToMany(mappedBy = "classGroup")
    private List<Fact> facts;
    
    public String getCode() {
        return code;
    }

    public void setCode(String c) {
        this.code = c;
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
        if (!(object instanceof ClassGroup)) {
            return false;
        }
        ClassGroup other = (ClassGroup) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.ClassGroup[code=" + code + "]";
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



}
