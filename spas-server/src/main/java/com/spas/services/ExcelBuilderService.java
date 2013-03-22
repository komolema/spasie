/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services;

import com.spas.util.excel.ExcelInfo;
import com.spas.util.excel.ExcelStrategy;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.InputStream;

/**
 *
 * @author Dada
 */
@WebService
public interface ExcelBuilderService {
   
    public void buildInfo(@WebParam(name = "ei") ExcelInfo ei, @WebParam(name = "es") ExcelStrategy es);
    
    public void buildInfo2(@WebParam(name = "io") InputStream io, @WebParam(name = "es") ExcelStrategy es) throws Exception;
}
