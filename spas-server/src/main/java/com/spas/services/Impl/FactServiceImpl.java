/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Fact;
import com.spas.services.FactService;

import javax.jws.WebService;

/**
 *
 * @author Z
 */
@WebService(endpointInterface = "com.spas.services.FactService")
public class FactServiceImpl extends CrudServiceImpl<Integer,Fact> implements FactService{


}
