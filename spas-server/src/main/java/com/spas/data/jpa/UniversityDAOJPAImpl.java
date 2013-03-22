/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.UniversityDAO;
import com.spas.model.University;

/**
 *
 * @author yawaco
 */
@Transactional
public class UniversityDAOJPAImpl extends CrudDAOJPAImpl<String,University> implements UniversityDAO{



}
