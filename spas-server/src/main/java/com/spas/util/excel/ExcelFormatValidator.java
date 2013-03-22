/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.util.excel;

import jxl.Sheet;
import com.spas.exception.ExcelFormatException;

/**
 *
 * @author komolema
 */
public interface ExcelFormatValidator {
    public  void validate(Sheet s) throws ExcelFormatException;
}
