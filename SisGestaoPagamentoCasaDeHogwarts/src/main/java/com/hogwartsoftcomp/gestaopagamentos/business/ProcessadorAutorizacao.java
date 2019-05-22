/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hogwartsoftcomp.gestaopagamentos.business;

import com.hogwartsoftcomp.gestaopagamentos.model.Pagamento;
import java.util.ArrayList;

/**
 *
 * @author Harrison
 */
public final class ProcessadorAutorizacao {

    private ArrayList<AutorizadorPagamento> autorizadores;
    private static ProcessadorAutorizacao instancia;

    private ProcessadorAutorizacao() {
        this.autorizadores = new ArrayList<>();
        autorizadores.add(new GerenteImediato(true));
        autorizadores.add(new GerenteGeral(true));
        autorizadores.add(new DiretorFinanceiro(true));
        autorizadores.add(new DiretorGeral(true));
    }

    public static ProcessadorAutorizacao getInstance() {
        if (instancia == null) {
            instancia = new ProcessadorAutorizacao();
        }
        return instancia;
    }

    public boolean processar(Pagamento pag) {
        for (AutorizadorPagamento autorizador : autorizadores) {
            if (autorizador.aceita(pag)) {
                autorizador.autoriza(pag);
                return true;
            }
        }
        return false;
    }

    public boolean add(AutorizadorPagamento a) {
        return this.autorizadores.add(a);
    }

}
