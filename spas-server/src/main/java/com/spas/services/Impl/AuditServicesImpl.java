/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Audit;
import com.spas.services.AuditServices;

import javax.jws.WebService;

/**
 *
 * @author ngcobozi
 */
@WebService(endpointInterface = "com.spas.services.AuditServices")
public class AuditServicesImpl extends CrudServiceImpl<Long,Audit> implements  AuditServices {

 
}
