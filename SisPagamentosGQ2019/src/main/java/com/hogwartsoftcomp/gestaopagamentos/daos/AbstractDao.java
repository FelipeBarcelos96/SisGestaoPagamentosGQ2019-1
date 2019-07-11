/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.daos;

import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Felipe
 */
public abstract class AbstractDao<T> implements IGenericDAO<T> {

    SessionFactory sessionFactory;
    Session session;
    private Transaction transaction;
    Class<T> clazz;

    public AbstractDao(Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
        if (sessionFactory == null) {
            throw new RuntimeException("Sessão nula");
        }
    }

    public void openSession() {
        this.session = sessionFactory.getCurrentSession();
    }

    public void openSessionTransaction() {
        this.session = this.sessionFactory.getCurrentSession();
        this.transaction = session.beginTransaction();

    }

    public void closeSession() {
        this.session.close();
    }

    @Override
    public T get(Integer id) {
        openSessionTransaction();
        @SuppressWarnings("unchecked")
        T element = (T) session.get(this.clazz, id);
        session.getTransaction().commit();
        closeSession();
        return element;
    }

    @Override
    public T save(T object) {
        openSessionTransaction();
        session.save(object);
        session.getTransaction().commit();
        closeSession();
        return object;
    }

    @Override
    public void update(T object) {
        openSessionTransaction();
        session.update(object);
        session.getTransaction().commit();
        closeSession();
    }

    @Override
    public void delete(T object) {
        openSessionTransaction();
        session.delete(object);
        session.getTransaction().commit();
        closeSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        openSessionTransaction();
        Query query = session.createQuery(hsql);
        if (params != null) {
            for (String i : params.keySet()) {
                query.setParameter(i, params.get(i));
            }
        }

        List<T> result = null;
        if ((hsql.toUpperCase().indexOf("DELETE") == -1)
                && (hsql.toUpperCase().indexOf("UPDATE") == -1)
                && (hsql.toUpperCase().indexOf("INSERT") == -1)) {
            result = query.list();
        } else {
        }
        session.getTransaction().commit();
        closeSession();
        return result;
    }

}
