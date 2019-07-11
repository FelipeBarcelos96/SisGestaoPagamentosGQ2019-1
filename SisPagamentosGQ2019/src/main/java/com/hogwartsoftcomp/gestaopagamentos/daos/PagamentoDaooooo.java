/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.daos;


import com.hogwartsoftcomp.gestaopagamentos.model.Pagamento;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

/**
 *
 * @author Felipe
 */
public class PagamentoDaooooo extends AbstractDao<Pagamento> {
    
    public PagamentoDaooooo(Class<Pagamento> clazz, SessionFactory sessionFactory) {
        super(clazz, sessionFactory);
    }

    @Override
    public Pagamento get(Integer id) {
        openSessionTransaction();
        Pagamento pagamento = session.get(clazz, id);

        Hibernate.initialize(pagamento.getSolicitante());
        Hibernate.initialize(pagamento.getOcorrencias());

        closeSession();
        return pagamento;
    }

    @Override
    public Pagamento save(Pagamento object) {
        openSessionTransaction();
        session.save(object);
        session.getTransaction().commit();
        closeSession();
        return object;
    }

}