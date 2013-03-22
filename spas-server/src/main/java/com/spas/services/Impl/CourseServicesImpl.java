/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Course;
import com.spas.services.CourseServices;

import javax.jws.WebService;

/**
 *
 * @author yawaco
 */
@WebService(endpointInterface = "com.spas.services.CourseServices")
public class CourseServicesImpl extends CrudServiceImpl<String,Course> implements CourseServices{


}
