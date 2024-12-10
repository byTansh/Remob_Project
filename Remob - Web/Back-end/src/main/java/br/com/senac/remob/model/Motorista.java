package br.com.senac.remob.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "motorista")
public class Motorista extends Usuario{

    @OneToOne
    @JoinColumn(name="veiculo_id", referencedColumnName = "id")
    private Veiculo  veiculo;

    @Column
    private int rg;

    @Column
    private int cnh;

    @Column
    private String status;

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getRg() {
        return this.rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCnh() {
        return this.cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}