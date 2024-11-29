package br.com.senac.remob.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column
    private int IdPassageiro;

    @Column
    private int IdMotorista;

    @Column int IdViagem;
    

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

    public int getIdViagem() {
        return IdViagem;
    }

    public void setIdViagem(int idViagem) {
        IdViagem = idViagem;
    }

    

}