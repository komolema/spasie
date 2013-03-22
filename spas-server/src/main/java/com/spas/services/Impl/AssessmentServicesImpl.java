/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.model.Assessment;
import com.spas.services.AssessmentServices;

import javax.jws.WebService;

/**
 *
 * @author Z
 */
@WebService(endpointInterface = "com.spas.services.AssessmentServices")
public class AssessmentServicesImpl extends CrudServiceImpl<Long,Assessment> implements AssessmentServices{

   
}
