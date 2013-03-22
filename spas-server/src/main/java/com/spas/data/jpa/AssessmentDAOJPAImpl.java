/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.AssessmentDAO;
import com.spas.model.Assessment;

/**
 *
 * @author 207041105
 */
@Transactional
public class AssessmentDAOJPAImpl extends CrudDAOJPAImpl<Long,Assessment> implements AssessmentDAO{


}
