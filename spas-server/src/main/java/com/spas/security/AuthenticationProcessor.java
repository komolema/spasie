/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.security;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spas.exception.SpasLoginException;
import com.spas.model.Roles;
import com.spas.model.SystemUser;
import com.spas.services.RoleServices;
import com.spas.services.SystemUserServices;

import java.io.Serializable;

/**
 *
 * @author Z
 */
public abstract class AuthenticationProcessor implements Serializable{
    private static ApplicationContext ctx;
    protected SystemUserServices systemUserService;
    protected RoleServices roleService;
    protected String loginType;

    protected Login silentLogin;
    private boolean silentLoginEnabled = true;
    AuthenticationProcessor()
    {
        init();
    }

    private AuthenticationProcessor nextProcessor;

    //public methods
    public Login processLogin(Login l) throws SpasLoginException
    {
        if(l.getType().equals(loginType))
        {
            return doAuthentication(l);
        }
        else
        {
            if(nextProcessor != null)
            {
                return nextProcessor.processLogin(l);
            }
        }

        ///the login has failed
        throw new SpasLoginException("Login failed");
    }

    public void setNextAuthenticationProcessor(AuthenticationProcessor nextProcessor)
    {
        this.nextProcessor = nextProcessor;
    }
    
       public String getLoginType() {
        return loginType;
    }
    
     public void init()
    {
        ctx = new ClassPathXmlApplicationContext("classpath:za/ac/cput/spas/conf/applicationContext.xml");
        systemUserService = (SystemUserServices) ctx.getBean("systemuserService");
        roleService = (RoleServices) ctx.getBean("roleService");
        silentLogin = new Login();
        silentLogin.setUserSupName("silent");
        silentLogin.setUserSupPassword("silent");
        createRoles();
   
    }

    //protected methods
    protected Login doAuthentication(Login l)
    {
        throw new UnsupportedOperationException("method not supposed to be thrown,please use a concrete implementation of this class not this class because it is supposed to be abstract");
    }

    

    /**
     * @return the loginType
     */
 
    protected SystemUser loadUserFromDatabase(Login l)
    {
        SystemUser retuser = null;
        Roles role = null;
        if(isSilentLogin(l))
        {
            retuser = new SystemUser();
            retuser.setName("silent");
            retuser.setPassword("silent");
            retuser.setEnabled(1);
            role = new Roles();
            role.setName("silent");

            retuser.setRole(role);
            return retuser;
        }
        retuser = systemUserService.getByProperty("Name",l.getUserSupName());

        return retuser;
    }

    protected boolean isAuthenticated(Login l)
    {
            throw new UnsupportedOperationException("method not supposed to be thrown,please use a concrete implementation of this class not this class because it is supposed to be abstract");
    }

    protected boolean isSilentLogin(Login l)
    {
        if(silentLoginEnabled == true){
            if((silentLogin.getUserSupName().equals(l.getUserSupName())) &&
                (silentLogin.getUserSupPassword().equals(l.getUserSupPassword()))){
                return true;
            }
        }
        return false;
    }

    protected void createRoles()
    {
        //this is an ugly hack could have been done much better
        try
        {
            Roles role = roleService.getByProperty("Name",Login.NOVELLLDAP_STAFF_MAIN);
            if(role == null)
            {
                role = new Roles();
                role.setName(Login.NOVELLLDAP_STAFF_MAIN);
                roleService.add(role);
            }

            Roles role2 = roleService.getByProperty("Name",Login.NOVELLLDAP_STUDENT_MAIN);
            if(role2 == null)
            {
                role2 = new Roles();
                role2.setName(Login.NOVELLLDAP_STUDENT_MAIN);
                roleService.add(role2);
            }

            Roles role3 = roleService.getByProperty("Name",Login.SPAS_CUSTOM);
            if(role3 == null)
            {
                role3 = new Roles();
                role3.setName(Login.SPAS_CUSTOM);
                roleService.add(role3);
            }
        }
        catch(Exception ex)
        {

        }
    }
}
