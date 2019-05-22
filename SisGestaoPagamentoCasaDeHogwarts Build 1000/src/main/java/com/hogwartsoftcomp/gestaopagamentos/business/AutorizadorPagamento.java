package com.hogwartsoftcomp.gestaopagamentos.business;

import com.hogwartsoftcomp.gestaopagamentos.model.Pagamento;

public abstract class AutorizadorPagamento {

    private boolean disponivel;

    protected AutorizadorPagamento(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public abstract void autoriza(Pagamento pag);

    public abstract boolean aceita(Pagamento pag);

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
