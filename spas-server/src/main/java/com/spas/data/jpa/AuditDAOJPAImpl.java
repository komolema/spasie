/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import java.util.List;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import com.spas.data.AuditDAO;
import com.spas.model.Audit;

/**
 *
 * @author ngcobozi
 */
@Transactional
public class AuditDAOJPAImpl extends CrudDAOJPAImpl<Long,Audit> implements AuditDAO {



}
