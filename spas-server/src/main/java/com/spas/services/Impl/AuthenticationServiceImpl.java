/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.services.AuthenticationService;
import org.springframework.security.ldap.SpringSecurityLdapTemplate;
import com.spas.security.Login;

/**
 *
 * @author Z
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    private SpringSecurityLdapTemplate sslTemplate;

    public boolean authenticate(Login l) {
        return false;

    }

    /**
     * @return the sslTemplate
     */
    public SpringSecurityLdapTemplate getSslTemplate() {
        return sslTemplate;
    }

    /**
     * @param sslTemplate the sslTemplate to set
     */
    public void setSslTemplate(SpringSecurityLdapTemplate sslTemplate) {
        this.sslTemplate = sslTemplate;
    }

}
