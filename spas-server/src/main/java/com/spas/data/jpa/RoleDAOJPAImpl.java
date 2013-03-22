/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.RoleDAO;
import com.spas.model.Roles;

/**
 *
 * @author ngcobozi
 */
@Transactional
public class RoleDAOJPAImpl extends CrudDAOJPAImpl<Long,Roles> implements RoleDAO {


}
