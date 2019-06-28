/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.servico;


import com.hogwartsoftcomp.gestaopagamentos.daos.FuncionarioDao;
import com.hogwartsoftcomp.gestaopagamentos.daos.PagamentoDaooooo;
import com.hogwartsoftcomp.gestaopagamentos.daos.HibernateUtil;
import com.hogwartsoftcomp.gestaopagamentos.daos.OcorrenciaDao;
import com.hogwartsoftcomp.gestaopagamentos.model.Funcionario;
import com.hogwartsoftcomp.gestaopagamentos.model.OcorrenciasPagamento;
import com.hogwartsoftcomp.gestaopagamentos.model.Pagamento;

/**
 *
 * @author Felipe
 */
public class PagamentoService extends GenericService<Pagamento> {
    
    
    private FuncionarioDao funcionarioDao;
    private OcorrenciaDao ocorrenciaDao;

    public PagamentoService() {
        super.clazz = Pagamento.class;
        super.dao = new PagamentoDaooooo(Pagamento.class, HibernateUtil.getSessionFactory());
        funcionarioDao = new FuncionarioDao(Funcionario.class,HibernateUtil.getSessionFactory());
        ocorrenciaDao = new OcorrenciaDao(OcorrenciasPagamento.class,HibernateUtil.getSessionFactory());
    }
   
    
}
