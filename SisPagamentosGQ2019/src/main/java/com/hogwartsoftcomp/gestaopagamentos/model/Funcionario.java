package com.hogwartsoftcomp.gestaopagamentos.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @NotEmpty(message = "O nome é obrigatório")
    private String nome;
    
    @NotEmpty(message = "O cargo é obrigatório")
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



}
