/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.servico;

import com.hogwartsoftcomp.gestaopagamentos.daos.FuncionarioDao;
import com.hogwartsoftcomp.gestaopagamentos.daos.HibernateUtil;

import com.hogwartsoftcomp.gestaopagamentos.model.Funcionario;

/**
 *
 * @author Felipe
 */
public class FuncionarioService extends GenericService<Funcionario> {
    
    

    public FuncionarioService() {
        super.clazz = Funcionario.class;
        super.dao = new FuncionarioDao(Funcionario.class, HibernateUtil.getSessionFactory());
        
    }
   
    
}
