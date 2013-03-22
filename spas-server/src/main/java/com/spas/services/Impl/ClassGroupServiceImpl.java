/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.ClassGroup;
import com.spas.services.ClassGroupService;

import javax.jws.WebService;

/**
 *
 * @author 207163413
 */
@WebService(endpointInterface = "com.spas.services.ClassGroupService")
public class ClassGroupServiceImpl extends CrudServiceImpl<String,ClassGroup> implements ClassGroupService{

}
