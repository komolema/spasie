/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Faculty;
import com.spas.services.FacultyServices;

import javax.jws.WebService;

/**
 *
 * @author yawaco
 */
@WebService(endpointInterface = "com.spas.services.FacultyServices")
public class FacultyServicesImpl extends CrudServiceImpl<String,Faculty> implements FacultyServices{

   
}
