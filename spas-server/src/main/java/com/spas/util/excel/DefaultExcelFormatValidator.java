/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.util.excel;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import com.spas.exception.ExcelFormatException;

/**
 *
 * @author komolema
 */
public class DefaultExcelFormatValidator implements ExcelFormatValidator {

    private Sheet dSheet;
   
    private ExcelLoc loc;
    private DefaultExcelFormat ef;

    public DefaultExcelFormatValidator()
    {
        
        ef = new DefaultExcelFormat();
        loc = ef.createLoc();
    }

  
    public void validate(Sheet s) throws ExcelFormatException {
        this.dSheet = s;

        //check if there is a test counter
        if((getCell(loc.getNumTestLoc()).getType()) == CellType.EMPTY)
        {
            throw new ExcelFormatException("Excel Format in wrong format:test indicator missing");
        }

        //check if there is student counter
        if((getCell(loc.getNumStudentLoc()).getType()) == CellType.EMPTY)
        {
            throw new ExcelFormatException("Excel Format in wrong format:student indicator missing");
        }

        //check if there is lecturer information
        if((getCell(loc.getLecturerLoc()).getType()) == CellType.EMPTY)
        {
            throw new ExcelFormatException("Excel Format in wrong format:lecturer id missing");
        }
        //check if there is subject information
        if((getCell(loc.getSubCodeLoc()).getType()) == CellType.EMPTY)
        {
            throw new ExcelFormatException("Excel Format in wrong format:subject id missing");
        }
    }

    //method takes a cell as a parameter and returns a cell
    private Cell getCell(int row,int column)
    {

        Cell tmpCell= dSheet.getCell(column,row);
        return tmpCell;
    }

    private Cell getCell(ExcelCell cLoc)
    {
        return this.getCell(cLoc.getRow(),cLoc.getColumn());
    }

}
