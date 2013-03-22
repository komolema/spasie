/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spas.services.Impl;

import com.spas.model.Subject;
import com.spas.services.SubjectService;

import javax.jws.WebService;

/**
 *
 * @author 207041105
 */
@WebService(endpointInterface = "com.spas.services.SubjectService")
public class SubjectServiceImpl extends CrudServiceImpl<String,Subject> implements SubjectService {

    
}
