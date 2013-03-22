/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services;

import javax.sql.DataSource;
import java.util.List;

/**
 *
 * @author yawaco
 */
public interface StatisticServices {
    public void setDataSource(DataSource ds);
    public List getTopStudentsPerSubject();
    public List getTopStudentPerCource();
    public List getTopStudentPerTest();
    public List getStudentInDangerPerSubject();
    public List getStudentsInDangerOverall();

    public void createTopStudentsPerSubject();
    public void createTopStudentPerCourse();
    public void createTopStudentPerTest();
    public void createStudentInDangerPerSubject();
    public void createStudentsInDangerOverall();

}
