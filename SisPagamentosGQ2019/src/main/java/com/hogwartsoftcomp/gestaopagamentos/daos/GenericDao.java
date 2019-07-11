/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.daos;

import org.hibernate.SessionFactory;

/**
 *
 * @author Felipe
 */
public class GenericDao<T> extends AbstractDao<T> {
    
    public GenericDao(Class<T> clazz, SessionFactory sessionFactory) {
        super(clazz, sessionFactory);
    }
    
}
