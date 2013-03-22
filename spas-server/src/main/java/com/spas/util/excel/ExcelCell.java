/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.util.excel;

/**
 *
 * @author 207163413
 */
public class ExcelCell {
    private int column;
    private int row;


    //constructors
    ExcelCell(){}

    ExcelCell(int r,int c)
    {
        column  = c;
        row     = r;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }
}
