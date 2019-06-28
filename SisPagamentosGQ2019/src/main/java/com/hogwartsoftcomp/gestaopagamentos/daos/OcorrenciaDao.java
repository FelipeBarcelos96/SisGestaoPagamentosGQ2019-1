package com.hogwartsoftcomp.gestaopagamentos.daos;


import com.hogwartsoftcomp.gestaopagamentos.model.OcorrenciasPagamento;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

/**
 *
 * @author Felipe
 */
public class OcorrenciaDao extends AbstractDao<OcorrenciasPagamento> {
    
    public OcorrenciaDao(Class<OcorrenciasPagamento> clazz, SessionFactory sessionFactory) {
        super(clazz, sessionFactory);
    }

    @Override
    public OcorrenciasPagamento get(Integer id) {
        openSessionTransaction();
        OcorrenciasPagamento ocorrencia = session.get(clazz, id);

        closeSession();
        return ocorrencia;
    }

    @Override
    public OcorrenciasPagamento save(OcorrenciasPagamento object) {
        openSessionTransaction();
        session.save(object);
        session.getTransaction().commit();
        closeSession();
        return object;
    }

}