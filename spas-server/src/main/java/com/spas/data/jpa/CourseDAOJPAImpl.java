/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import java.util.List;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import com.spas.data.CourseDAO;
import com.spas.model.Course;

/**
 *
 * @author yawaco
 */
@Transactional
public class CourseDAOJPAImpl extends CrudDAOJPAImpl<String,Course> implements CourseDAO{



}
