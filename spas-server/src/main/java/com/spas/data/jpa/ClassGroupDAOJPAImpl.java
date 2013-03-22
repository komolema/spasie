/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.ClassGroupDAO;
import com.spas.model.ClassGroup;

/**
 *
 * @author 207163413
 */
@Transactional
public class ClassGroupDAOJPAImpl extends CrudDAOJPAImpl<String,ClassGroup> implements ClassGroupDAO {

  

}
