package com.hogwartsoftcomp.gestaopagamentos.business;

import com.hogwartsoftcomp.gestaopagamentos.model.OcorrenciasPagamento;
import com.hogwartsoftcomp.gestaopagamentos.model.Pagamento;
import java.util.Date;

public class DiretorFinanceiro extends AutorizadorPagamento {

    DiretorFinanceiro(boolean disponivel) {
        super(disponivel);
    }

    @Override
    public boolean aceita(Pagamento pag) {
        if (isDisponivel()) {
            if (pag.getValor() > 0 && pag.getValor() <= 5000.00) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void autoriza(Pagamento pag) {
        Date data = new Date();
        OcorrenciasPagamento o;

        if (pag.getDataVencimento().after(data)) {
            String descricao = "O Diretor Financeiro não pôde autorizar o pagamento pelo fato do mesmo estar vencido.";
            o = new OcorrenciasPagamento(data, descricao, pag.getSolicitante().getNome());
            pag.addOcorrencia(o);
        } else {
            String descricao = "Pagamento no valor de R$ "+ pag.getValor()+ " foi autorizado pelo Diretor Financeiro.";
            o = new OcorrenciasPagamento(data, descricao, pag.getSolicitante().getNome());
            pag.addOcorrencia(o);
        }
    }

}
