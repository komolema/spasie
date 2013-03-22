/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.data.StatisticsDAO;
import com.spas.services.StatisticServices;

import javax.sql.DataSource;
import java.util.List;

/**
 *
 * @author yawaco
 */
public class StatisticServicesImpl implements StatisticServices {

    private StatisticsDAO dao;
    public void setDataSource(DataSource ds) {
        dao.setDataSource(ds);
    }

    public List getTopStudentsPerSubject() {
       return dao.getTopStudentsPerSubject();
    }

    public List getTopStudentPerCource() {
        return dao.getTopStudentPerCource();
    }

    public List getTopStudentPerTest() {
       return dao.getTopStudentPerTest();
    }

    public List getStudentInDangerPerSubject() {
        return dao.getStudentInDangerPerSubject();
    }

    public List getStudentsInDangerOverall() {
        return dao.getStudentsInDangerOverall();
    }

    /**
     * @return the dao
     */
    public StatisticsDAO getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(StatisticsDAO dao) {
        this.dao = dao;
    }

    public void createTopStudentsPerSubject() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createTopStudentPerCourse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createTopStudentPerTest() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createStudentInDangerPerSubject() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createStudentsInDangerOverall() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
