/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.security;

import com.spas.model.SystemUser;

/**
 *
 * @author Z
 */
public class Login {

    private String type;
    private String userSupName; // username supplied by user
    private String userSupPassword; // password supplied by user

    //login types
    public static final String NOVELLLDAP_STUDENT_MAIN="novell_student_main";
    public static final String NOVELLLDAP_STAFF_MAIN="novell_staff_main";


    public static final String SPAS_CUSTOM ="spas_custom";

    private SystemUser user=null;
    //constructor
    public Login(){}

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the userSupName
     */
    public String getUserSupName() {
        return userSupName;
    }

    /**
     * @param userSupName the userSupName to set
     */
    public void setUserSupName(String userSupName) {
        this.userSupName = userSupName;
    }

    /**
     * @return the userSupPassword
     */
    public String getUserSupPassword() {
        return userSupPassword;
    }

    /**
     * @param userSupPassword the userSupPassword to set
     */
    public void setUserSupPassword(String userSupPassword) {
        this.userSupPassword = userSupPassword;
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

    public boolean isAuthennticated()
    {
        if(user == null)
        {
            return false;
        }
        else if(user.getEnabled() == 0)
        {
            return false;
        }
        return true;
    }

}
