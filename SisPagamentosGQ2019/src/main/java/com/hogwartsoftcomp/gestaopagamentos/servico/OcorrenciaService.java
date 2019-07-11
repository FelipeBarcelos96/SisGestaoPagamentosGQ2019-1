/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.servico;


import com.hogwartsoftcomp.gestaopagamentos.daos.HibernateUtil;
import com.hogwartsoftcomp.gestaopagamentos.daos.OcorrenciaDao;
import com.hogwartsoftcomp.gestaopagamentos.model.OcorrenciasPagamento;

/**
 *
 * @author Felipe
 */
public class OcorrenciaService extends GenericService<OcorrenciasPagamento> {
    
    

    public OcorrenciaService() {
        super.clazz = OcorrenciasPagamento.class;
        super.dao = new OcorrenciaDao(OcorrenciasPagamento.class, HibernateUtil.getSessionFactory());
        
    }
   
    
}
