/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Roles;
import com.spas.services.RoleServices;

import javax.jws.WebService;

/**
 *
 * @author ngcobozi
 */
@WebService(endpointInterface = "com.spas.services.RoleServices")
public class RoleServiceImpl extends CrudServiceImpl<Long,Roles> implements RoleServices {

}
