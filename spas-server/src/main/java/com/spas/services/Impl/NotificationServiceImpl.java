/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Notification;
import com.spas.services.NotificationService;

import javax.jws.WebService;

/**
 *
 * @author 207163413
 */
@WebService(endpointInterface = "com.spas.services.NotificationService")
public class NotificationServiceImpl extends CrudServiceImpl<Long,Notification> implements NotificationService {


}
