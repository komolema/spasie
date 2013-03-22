/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.SystemUserDAO;
import com.spas.model.SystemUser;



/**
 *
 * @author ngcobozi
 */
@Transactional
public class SystemUserDAOJPAImpl extends CrudDAOJPAImpl<Long,SystemUser> implements SystemUserDAO {


}
