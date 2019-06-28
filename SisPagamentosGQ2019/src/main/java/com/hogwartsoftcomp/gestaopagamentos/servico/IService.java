/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.servico;

/**
 *
 * @author Felipe
 */
import com.hogwartsoftcomp.gestaopagamentos.daos.IGenericDAO;
import java.util.List;

public interface IService<T> extends IGenericDAO<T> {

    List<T> getAll();

    void deleteAll();
}
