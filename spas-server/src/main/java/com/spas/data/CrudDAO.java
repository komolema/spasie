/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data;

import java.util.List;

/**
 *
 * @author komolema
 */
public interface CrudDAO<K,T> {
    public void add(T newInstance);
    
    public T get(K Id);
    public List<T> getAll();
    public void update(T instance);
    public void delete(T instance);
    public T getByProperty(String propertyName, String PropertyValue);
    public List<T> getAllByProperty(String propertyName, String PropertyValue);
}
