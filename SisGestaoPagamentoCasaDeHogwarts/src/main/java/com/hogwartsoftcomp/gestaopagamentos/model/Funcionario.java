package com.hogwartsoftcomp.gestaopagamentos.model;

import java.io.Serializable;

public class Funcionario implements Comparable<Funcionario>, Serializable {

    private String nome;
    private String cargo;

    public Funcionario(String pNome, String pCargo) {
        this.nome = pNome;
        this.cargo = pCargo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCargo() {
        return this.cargo;
    }

    @Override
    public String toString() {
        return "" + this.nome
                + "," + this.cargo;
    }

    public int compareTo(Funcionario o) {
        return nome.compareTo(o.nome);
    }
}
