/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.daos;

import com.hogwartsoftcomp.gestaopagamentos.model.Funcionario;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

/**
 *
 * @author Felipe
 */
public class FuncionarioDao extends AbstractDao<Funcionario> {
    
    public FuncionarioDao(Class<Funcionario> clazz, SessionFactory sessionFactory) {
        super(clazz, sessionFactory);
    }

    @Override
    public Funcionario get(Integer id) {
        openSessionTransaction();
        Funcionario funcionario = session.get(clazz, id);
        
        closeSession();
        return funcionario;
    }

    @Override
    public Funcionario save(Funcionario object) {
        openSessionTransaction();
        session.save(object);
        session.getTransaction().commit();
        closeSession();
        return object;
    }

}
