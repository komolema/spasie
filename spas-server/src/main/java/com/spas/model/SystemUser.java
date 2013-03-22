/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 207163413
 */
@Entity
public class SystemUser implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //attributes
    private String Name;
    private String Password;
    @Column(unique=true)
    private String lectNumber;
    private int enabled;
    //realationships
    @OneToMany
    private List<Audit> audits;
    
    @ManyToOne
    private Roles role;

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
        if (!(object instanceof SystemUser)) {
            return false;
        }
        SystemUser other = (SystemUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.spas.model.User[id=" + id + "]";
    }

   

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the audits
     */
    public List<Audit> getAudits() {
        return audits;
    }

    /**
     * @param audits the audits to set
     */
    public void setAudits(List<Audit> audits) {
        this.audits = audits;
    }

    /**
     * @return the role
     */
    public Roles getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Roles role) {
        this.role = role;
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
     * @return the enabled
     */
    public int getEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getLectNumber() {
        return lectNumber;
    }

    public void setLectNumber(String lectNumber) {
        this.lectNumber = lectNumber;
    }

}
