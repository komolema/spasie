/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.util.excel;

/**
 *
 * @author Dada
 * Details:The DefaultExcelFormat class creates a ExcelLoc
 * class with hard coded cell locations for the data
 */
public class DefaultExcelFormat implements ExcelFormat{

    

    //constructors
    public DefaultExcelFormat(){}

    public ExcelLoc createLoc() {
        
        return init();
    }

    /*helper methods*/
    public ExcelLoc init()
    {
        ExcelLoc retLoc = new ExcelLoc();
       

        //initialize locations for num tests
       
        retLoc.setNumTestLoc(new ExcelCell(10,13));

        //initialize locations for num students
       
        retLoc.setNumStudentLoc(new ExcelCell(11,13));

        //initialize locations for subject
     
        retLoc.setSubCodeLoc(new ExcelCell(1,2));
        retLoc.setSubNameLoc(new ExcelCell(1,4));
        //initialize locations for faculty
       
        retLoc.setFacultyLoc(new ExcelCell(3,2));

        //initialize locations for lecturer
     
        retLoc.setLecturerLoc(new ExcelCell(8,2));

        //initialize locations for class group
 
        retLoc.setClassCodeLoc(new ExcelCell(9,5));
        //initialize locations for student number
   
        retLoc.setStudentNoLoc(new ExcelCell(14,1));

        //initialize locations for student name
    
        retLoc.setStudentNameLoc(new ExcelCell(14,0));

        //initialize locations for course
      
        retLoc.setCourseCodeLoc(new ExcelCell(4,2));



        //initialize locations for mark
     
        retLoc.setMarkLoc(new ExcelCell(14,7));

        //initialize locations for test name
   
        retLoc.setTestNameLoc(new ExcelCell(13,7));

        //initialize locations for test weight
  
        retLoc.setTestWeightLoc(new ExcelCell(12,7));

        //initialize location for Campus
    
        retLoc.setCampusLoc(new ExcelCell(5,4));

        //initialize location for OfferingType
      
        retLoc.setOfferingTypeLoc(new ExcelCell(5,2));

        //initialize location for Calendar Year
       
        retLoc.setYearLoc(new ExcelCell(7,2));

        //initialize location for Cancel Date
    
        retLoc.setCancelLoc(new ExcelCell(14,5));

        //initialize location for faculty name
        retLoc.setFacultyNameLoc(new ExcelCell(3,4));

        //initialize location for course name
        retLoc.setCourseNameLoc(new ExcelCell(4,4));
        //return
        return retLoc;
    }
}
