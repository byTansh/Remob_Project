package br.com.senac.remob.model;

import java. util. Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity

public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int rg;
    
    @JoinColumn(name="veiculo_id", referencedColumnName = "id")
    private Veiculo  veiculo;

    @Column
    private String cpf;

    @Column
    private String email;

    @Column
    private String nome;

    @Column
    private String senha;

    @Column
    private int telefone;

    @Column
    private String sexo;

    @Column
    private Date idade;
}