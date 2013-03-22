/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.SubjectDAO;
import com.spas.model.Subject;
 
/**
 *
 * @author 207041105
 */
@Transactional
public class SubjectDAOImpl extends CrudDAOJPAImpl<String,Subject> implements SubjectDAO{



}
