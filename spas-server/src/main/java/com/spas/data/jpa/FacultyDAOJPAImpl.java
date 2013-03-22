/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import java.util.List;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import com.spas.data.FacultyDAO;
import com.spas.model.Faculty;

/**
 *
 * @author yawaco
 */
@Transactional
public class FacultyDAOJPAImpl extends CrudDAOJPAImpl<String,Faculty> implements FacultyDAO{


}
