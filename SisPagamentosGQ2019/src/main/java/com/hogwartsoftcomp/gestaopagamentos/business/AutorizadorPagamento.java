package com.hogwartsoftcomp.gestaopagamentos.business;

import com.hogwartsoftcomp.gestaopagamentos.model.OcorrenciasPagamento;
import com.hogwartsoftcomp.gestaopagamentos.model.Pagamento;
import com.hogwartsoftcomp.gestaopagamentos.utils.ValidaData;
import java.util.Date;

public class AutorizadorPagamento {

    private boolean disponivel;
    private String nomeAutorizador;
    private double limiteSuperior;

    public AutorizadorPagamento(String nomeAutorizador, double limiteSuperior) {
        this.nomeAutorizador = nomeAutorizador;
        this.limiteSuperior = limiteSuperior;
        this.disponivel = true;
    }

    public void autoriza(Pagamento pag) {
        ValidaData data = ValidaData.getInstance();
        Date dataAtualZerada = data.getDataZerada();

        OcorrenciasPagamento o;

        String descricao = "Pagamento no valor de R$" + pag.getValor() + " foi autorizado pelo " + this.nomeAutorizador + ".";
        o = new OcorrenciasPagamento(dataAtualZerada, descricao, pag.getSolicitante().getNome());
        pag.addOcorrencia(o);
        pag.setDataPagamento(dataAtualZerada);
    }

    public boolean aceita(Pagamento pag) {

        ValidaData validaData = ValidaData.getInstance();
        Date data = validaData.getDataZerada();
        String descricao;

        OcorrenciasPagamento o;
        if (isDisponivel()) {
            if (pag.getDataVencimento().getTime() >= data.getTime()) {
                if (pag.getValor() > 0 && pag.getValor() <= this.limiteSuperior) {
                    autoriza(pag);
                    return true;
                }
            } else {
                descricao = "O " + this.nomeAutorizador + " não pôde autorizar o pagamento pelo fato do mesmo estar vencido.";
                o = new OcorrenciasPagamento(data, descricao, pag.getSolicitante().getNome());
                pag.addOcorrencia(o);
            }
        } else {
            descricao = "O " + this.nomeAutorizador + " não pôde autorizar o pagamento no valor "
                    + pag.getValor() + " por estar indisponível.";
            o = new OcorrenciasPagamento(data, descricao, pag.getSolicitante().getNome());
            pag.addOcorrencia(o);
            return false;
        }
        return false;
    }

    public boolean isDisponivel() {
        return disponivel;
    }



}
