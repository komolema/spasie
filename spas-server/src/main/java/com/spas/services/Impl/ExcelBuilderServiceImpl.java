/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.services.ExcelBuilderService;
import com.spas.util.excel.ExcelInfo;
import com.spas.util.excel.ExcelStrategy;

import javax.jws.WebService;
import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author Dada
 */
@WebService(endpointInterface = "com.spas.services.ExcelBuilderService")
public class ExcelBuilderServiceImpl implements ExcelBuilderService,Serializable{

    private ExcelInfo ei;
    private ExcelStrategy es;
    public void buildInfo(ExcelInfo ei,ExcelStrategy es) {
        
        this.ei = ei;
        this.es    = es;

        persist();
    }

    public void buildInfo2(InputStream io,ExcelStrategy es) throws Exception{
        ExcelInfo tmpEi = new ExcelInfo(io);
        buildInfo(tmpEi,es);
    }

    private void persist()
    {
        es.persistToDatabase(ei);
    }
}
