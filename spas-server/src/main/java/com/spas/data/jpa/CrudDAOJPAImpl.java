/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import java.lang.Class;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import com.spas.data.CrudDAO;

/**
 *
 * @author komolema
 */
@Transactional
public class CrudDAOJPAImpl<K,T> extends JpaDaoSupport implements CrudDAO<K,T>{

    protected Class<T> entityClass;

    public CrudDAOJPAImpl()
    {
        ParameterizedType s = (ParameterizedType)getClass().getGenericSuperclass();
        entityClass = (Class<T>)s.getActualTypeArguments()[1];
        
    }

    public void add(T newInstance) {
        getJpaTemplate().persist(newInstance);
    }

    public T get(K Id) {
         
        return (T) getJpaTemplate().find(entityClass, Id);
    }

    public List<T> getAll() {
        
        String className = entityClass.getSimpleName();

        return getJpaTemplate().find("from "+className);
    }

    public void update(T instance) {
        getJpaTemplate().merge(instance);
    }

     public void delete(T instance) {

        getJpaTemplate().remove(instance);
    }

    public T getByProperty(String propertyName, String value) {
       
        List<T> all = getAllByProperty(propertyName, value);
        return (all.isEmpty()) ? null : (T) all.get(0);

    }

    public List<T> getAllByProperty(String propertyName, String value) {
    
        List<T> all = getJpaTemplate().find("Select m "+" FROM "+ entityClass.getSimpleName() + " m Where m."+ propertyName +"=?1", value);
        return (all.isEmpty()) ? null : all;
    }



}
