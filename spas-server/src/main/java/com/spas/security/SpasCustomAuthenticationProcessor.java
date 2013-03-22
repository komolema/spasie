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
public class SpasCustomAuthenticationProcessor extends AuthenticationProcessor{
    public SpasCustomAuthenticationProcessor()
    {
        loginType = Login.SPAS_CUSTOM;
    }

    @Override
    public Login doAuthentication(Login l)
    {
        Login newLogin = null;

        if(isAuthenticated(l))
        {
            l.setUser(loadUserFromDatabase(l));
            return l;
        }


        return newLogin;
    }

    @Override
    protected boolean isAuthenticated(Login l)
    {
        if(isSilentLogin(l)){
            return true;
        }
        SystemUser user = systemUserService.getByProperty("Name",l.getUserSupName());
        PasswordEncrypt encrypt;
        String loginPassword = null;
        String userPassword = null;
        if(user != null)
        {
            encrypt = new PasswordEncrypt();
            loginPassword = encrypt.encrypt(l.getUserSupPassword());
            userPassword = user.getPassword();
            if(userPassword.equals(loginPassword))
            {
                return true;
            }
        }
        return false;
    }
}
