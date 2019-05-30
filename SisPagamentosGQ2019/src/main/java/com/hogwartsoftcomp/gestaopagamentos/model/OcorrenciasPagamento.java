/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.model;

import java.util.Date;

/**
 *
 * @author Harrison
 */
public class OcorrenciasPagamento {

    private Date dataDaOcorrencia;
    private String descricao;
    private String solicitante;

    public OcorrenciasPagamento(Date dataDaOcorrencia, String descricao, String solicitante) {
        this.dataDaOcorrencia = dataDaOcorrencia;
        this.descricao = descricao;
        this.solicitante = solicitante;
    }

    public Date getDataDaOcorrencia() {
        return dataDaOcorrencia;
    }

    public void setDataDaOcorrencia(Date dataDaOcorrencia) {
        this.dataDaOcorrencia = dataDaOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    @Override
    public String toString() {
        return "OcorrenciasPagamento{" + "dataDaOcorrencia=" + dataDaOcorrencia + ", descricao=" + descricao + ", solicitante=" + solicitante + '}';
    }

}
