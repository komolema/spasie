/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import java.util.List;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import com.spas.data.StudentDAO;
import com.spas.model.Student;

/**
 *
 * @author Z
 */
@Transactional
public class StudentDAOJPAImpl extends CrudDAOJPAImpl<String,Student> implements StudentDAO {



}
