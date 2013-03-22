/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services;

import com.spas.model.Course;

import javax.jws.WebService;

/**
 *
 * @author yawaco
 */
@WebService
public interface CourseServices extends CrudService<String,Course>{
}
