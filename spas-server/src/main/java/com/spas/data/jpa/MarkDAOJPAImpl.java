/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.MarkDAO;
import com.spas.model.Mark;

/**
 *
 * @author 207041105
 */
@Transactional
public class MarkDAOJPAImpl extends CrudDAOJPAImpl<Long,Mark> implements MarkDAO{



}
