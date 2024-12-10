package br.com.senac.remob.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "passageiro")
public class Passageiro extends Usuario {

    @Column
    private String pne;

    public String getPne() {
        return this.pne;
    }

    public void setPne(String pne) {
        this.pne = pne;
    }
}