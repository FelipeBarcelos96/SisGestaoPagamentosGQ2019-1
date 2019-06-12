package com.hogwartsoftcomp.gestaopagamentos.model;

import com.hogwartsoftcomp.gestaopagamentos.utils.ValidaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pagamento {

    private String descricao;
    private double valor;
    private Date dataVencimento;
    private Date dataPagamento;
    private Funcionario solicitante;
    private ArrayList<OcorrenciasPagamento> ocorrencias;

    public Pagamento(String pdescricao, double pvalor, Date pdataVencimento, Date pdataPagamento, Funcionario psolicitante) {
        this.descricao = pdescricao;
        this.valor = pvalor;
        setDataVencimento(pdataVencimento);
        setDataPagamento(pdataPagamento);
        this.solicitante = psolicitante;
        ocorrencias = new ArrayList<>();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        if (ValidaData.getInstance().validaData(dataVencimento)) {
            this.dataVencimento = dataVencimento;
        }
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        if (ValidaData.getInstance().validaData(dataPagamento)) {
            this.dataPagamento = dataPagamento;
        }
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Funcionario solicitante) {
        this.solicitante = solicitante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "" + this.valor
                + "," + this.dataVencimento
                + "," + this.dataPagamento
                + "," + this.solicitante;
    }

    public List<OcorrenciasPagamento> getOcorrencias() {
        return ocorrencias;
    }

    public boolean addOcorrencia(OcorrenciasPagamento o) {
        return this.ocorrencias.add(o);
    }

}
