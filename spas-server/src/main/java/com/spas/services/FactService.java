/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services;

import com.spas.model.Fact;

import javax.jws.WebService;

/**
 *
 * @author Z
 */
@WebService
public interface FactService extends CrudService<Integer,Fact>{
 
}
