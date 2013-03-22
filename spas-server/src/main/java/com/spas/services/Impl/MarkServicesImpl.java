/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spas.services.Impl;

import com.spas.model.Mark;
import com.spas.services.MarkServices;

import javax.jws.WebService;

/**
 *
 * @author 207041105
 */
@WebService(endpointInterface = "com.spas.services.MarkServices")
public class MarkServicesImpl extends CrudServiceImpl<Long,Mark> implements MarkServices {

    
    
}
