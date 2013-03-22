/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import org.springframework.transaction.annotation.Transactional;
import com.spas.data.NotificationDAO;
import com.spas.model.Notification;

/**
 *
 * @author 207163413
 */
@Transactional
public class NotificationDAOJPAImpl extends CrudDAOJPAImpl<Long,Notification> implements NotificationDAO{


}
