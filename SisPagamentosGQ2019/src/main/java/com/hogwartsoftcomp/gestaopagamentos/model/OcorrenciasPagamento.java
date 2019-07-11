/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Harrison
 */
@Entity
@Table(name = "Ocorrencias")
public class OcorrenciasPagamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @NotNull
    private Date dataDaOcorrencia;
    @NotEmpty(message = "A descricao é obrigatória")
    private String descricao;
    @NotEmpty(message = "O nome do solicitante é obrigatório")
    private String solicitante;

    public OcorrenciasPagamento(Date dataDaOcorrencia, String descricao, String solicitante) {
        this.dataDaOcorrencia = dataDaOcorrencia;
        this.descricao = descricao;
        this.solicitante = solicitante;
    }

    public Date getDataDaOcorrencia() {
        return dataDaOcorrencia;
    }


    public String getDescricao() {
        return descricao;
    }



    public String getSolicitante() {
        return solicitante;
    }




}
