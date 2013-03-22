/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.services.Impl;

import com.spas.data.CrudDAO;
import com.spas.services.CrudService;

import java.util.List;

/**
 *
 * @author komolema
 */
public class CrudServiceImpl<K,T> implements  CrudService<K,T>{

    private CrudDAO dao;

    public void add(T newInstance) {
        dao.add(newInstance);
    }

 

    public T get(K Id) {
        return (T) dao.get(Id);
    }

    public List<T> getAll() {
        return dao.getAll();
    }

    public void update(T instance) {
        dao.update(instance);
    }

    public void delete(T instance) {
        dao.delete(instance);
    }

    public T getByProperty(String propertyName, String PropertyValue) {
        return (T) dao.getByProperty(propertyName, PropertyValue);
    }

    public List<T> getAllByProperty(String propertyName, String PropertyValue) {
        return dao.getAllByProperty(propertyName, PropertyValue);
    }

    /**
     * @return the dao
     */
    public CrudDAO getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(CrudDAO dao) {
        this.dao = dao;
    }

}
