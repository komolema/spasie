/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.FactDAO;
import com.spas.model.Fact;

/**
 *
 * @author Z
 */
@Transactional
public class FactDAOJPAImpl extends CrudDAOJPAImpl<Integer,Fact> implements FactDAO {


}
