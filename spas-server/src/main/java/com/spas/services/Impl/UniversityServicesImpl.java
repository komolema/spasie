/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.University;
import com.spas.services.UniversityServices;

import javax.jws.WebService;

/**
 *
 * @author yawaco
 */
@WebService(endpointInterface = "com.spas.services.UniversityServices")
public class UniversityServicesImpl extends CrudServiceImpl<String,University> implements UniversityServices {

}
