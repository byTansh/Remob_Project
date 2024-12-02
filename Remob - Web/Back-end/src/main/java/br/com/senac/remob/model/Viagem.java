package br.com.senac.remob.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "viagem")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String plano;

    @Column
    private String tipo;

    @Column
    private int IdPassageiro;

    @Column
    private int IdMotorista;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdPassageiro() {
        return IdPassageiro;
    }

    public void setIdPassageiro(int idPassageiro) {
        IdPassageiro = idPassageiro;
    }

    public int getIdMotorista() {
        return IdMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        IdMotorista = idMotorista;
    }

    
}