/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services;

import com.spas.security.Login;

/**
 *
 * @author Z
 */
public interface AuthenticationService {
    public boolean authenticate(Login l);
}
