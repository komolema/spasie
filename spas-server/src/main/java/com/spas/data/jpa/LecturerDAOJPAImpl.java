/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.LecturerDAO;
import com.spas.model.Lecturer;

/**
 *
 * @author 207163413
 */
@Transactional
public class LecturerDAOJPAImpl extends CrudDAOJPAImpl<String,Lecturer>implements LecturerDAO {

   
}
