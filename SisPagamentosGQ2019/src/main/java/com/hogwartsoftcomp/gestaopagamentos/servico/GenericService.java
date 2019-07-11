/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.servico;

import com.hogwartsoftcomp.gestaopagamentos.daos.GenericDao;
import com.hogwartsoftcomp.gestaopagamentos.daos.HibernateUtil;
import java.util.List;
import java.util.Map;
import com.hogwartsoftcomp.gestaopagamentos.daos.IGenericDAO;

/**
 *
 * @author Felipe
 */
public class GenericService<T> implements IService<T> {

    IGenericDAO<T> dao;
    Class<T> clazz;

    public GenericService() {
    }

    //dao generica
    public GenericService(Class<T> clazz) {
        this.clazz = clazz;
        this.dao = new GenericDao<T>(clazz, HibernateUtil.getSessionFactory());
    }

    @Override
    public T get(Integer id) {
        return (T) dao.get(id);
    }

    @Override
    public T save(T object) {
        return (T) dao.save(object);
    }

    @Override
    public void update(T object) {
        dao.update(object);
    }

    @Override
    public void delete(T object) {
        dao.delete(object);
    }

    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        return (List<T>) dao.query(hsql, params);
    }

    @Override
    public List<T> getAll() {
        return query("from " + clazz.getName(), null);
    }

    @Override
    public void deleteAll() {
        query("delete from " + clazz.getName(), null);

    }

}
