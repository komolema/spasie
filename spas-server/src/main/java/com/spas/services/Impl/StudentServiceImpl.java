/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Student;
import com.spas.services.StudentService;

import javax.jws.WebService;

/**
 *
 * @author Z
 */
@WebService(endpointInterface = "com.spas.services.StudentService")
public class StudentServiceImpl extends CrudServiceImpl<String,Student> implements StudentService{

}
