package com.hogwartsoftcomp.gestaopagamentos.model;

import com.hogwartsoftcomp.gestaopagamentos.utils.ValidaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Pagamento")
public class Pagamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
   
    @NotEmpty(message = "A descricao é obrigatória")
    private String descricao;
    
    @NotNull
    private double valor;
    
    @NotNull
    private Date dataVencimento;
    
    @NotNull
    private Date dataPagamento;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Funcionario solicitante;
    
    @OneToOne(cascade = CascadeType.ALL)
    private ArrayList<OcorrenciasPagamento> ocorrencias;

    public Pagamento(String pdescricao, double pvalor, Date pdataVencimento, Funcionario psolicitante) {
        this.descricao = pdescricao;
        this.valor = pvalor;
        setDataVencimento(pdataVencimento);
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
    
    public int getId(){
        return this.id;
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
