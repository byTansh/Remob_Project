package br.com.senac.remob.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double valorTotal;

    @Column
    private String formaPagamento;

    @OneToOne
    @JoinColumn (name = "passageiro_id", referencedColumnName = "id")
    private Passageiro passageiro;

    @OneToOne
    @JoinColumn (name = "motorista_id", referencedColumnName = "id")
    private Motorista motorista;

    @OneToOne
    @JoinColumn (name = "viagem_id", referencedColumnName = "id")
    private Viagem viagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Passageiro getPassageiro() {
        return this.passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Motorista getMotorista() {
        return this.motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Viagem getViagem() {
        return this.viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }
    

}