package com.hogwartsoftcomp.gestaopagamentos.model;

public class Funcionario {

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

}
