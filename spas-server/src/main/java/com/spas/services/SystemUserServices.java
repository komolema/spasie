/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services;

import com.spas.model.SystemUser;

import javax.jws.WebService;

/**
 *
 * @author ngcobozi
 */
@WebService
public interface SystemUserServices extends CrudService<Long,SystemUser>{

}
