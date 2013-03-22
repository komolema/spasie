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
public class Audit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //attributes
    private String Descr;

    //relationships
    @ManyToOne
    private SystemUser user;

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
        if (!(object instanceof Audit)) {
            return false;
        }
        Audit other = (Audit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.com.spas.model.Audit[id=" + id + "]";
    }

    
    /**
     * @return the user
     */
    public SystemUser getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(SystemUser user) {
        this.user = user;
    }

    /**
     * @return the Descr
     */
    public String getDescr() {
        return Descr;
    }

    /**
     * @param Descr the Descr to set
     */
    public void setDescr(String Descr) {
        this.Descr = Descr;
    }

}
