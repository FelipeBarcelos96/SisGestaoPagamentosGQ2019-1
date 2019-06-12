package com.hogwartsoftcomp.gestaopagamentos.business;

import com.hogwartsoftcomp.gestaopagamentos.model.OcorrenciasPagamento;
import com.hogwartsoftcomp.gestaopagamentos.model.Pagamento;
import java.util.Calendar;
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

    public void autoriza(Pagamento pag)  {
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        data = cal.getTime();
        
        OcorrenciasPagamento o;

        if (pag.getDataVencimento().getTime() >= data.getTime()) {
            String descricao = "Pagamento no valor de R$" + pag.getValor() + " foi autorizado pelo " + this.nomeAutorizador + ".";
            o = new OcorrenciasPagamento(data, descricao, pag.getSolicitante().getNome());
            pag.addOcorrencia(o);
            pag.setDataPagamento(data);
        } else {
            String descricao = "O " + this.nomeAutorizador + " não pôde autorizar o pagamento pelo fato do mesmo estar vencido.";
            o = new OcorrenciasPagamento(data, descricao, pag.getSolicitante().getNome());
            pag.addOcorrencia(o);
        }
    }

    public boolean aceita(Pagamento pag) {
        return (this.isDisponivel() && pag.getValor() > 0 && pag.getValor() <= this.limiteSuperior);
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public AutorizadorPagamento comDisponibilidade(boolean disponivel) {
        this.disponivel = disponivel;
        return this;
    }

}
