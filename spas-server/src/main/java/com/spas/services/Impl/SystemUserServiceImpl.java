/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.SystemUser;
import com.spas.services.SystemUserServices;

import javax.jws.WebService;

/**
 *
 * @author ngcobozi
 */
@WebService(endpointInterface = "com.spas.services.SystemUserServices")
public class SystemUserServiceImpl extends CrudServiceImpl<Long,SystemUser> implements SystemUserServices {

}
