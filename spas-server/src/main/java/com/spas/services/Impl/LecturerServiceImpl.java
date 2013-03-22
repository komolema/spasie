/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Lecturer;
import com.spas.services.LecturerService;

import javax.jws.WebService;

/**
 *
 * @author 207163413
 */
@WebService(endpointInterface = "com.spas.services.LecturerService")
public class LecturerServiceImpl extends CrudServiceImpl<String,Lecturer>  implements LecturerService{
 

}
