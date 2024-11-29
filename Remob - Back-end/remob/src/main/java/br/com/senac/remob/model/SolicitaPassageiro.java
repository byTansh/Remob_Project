package br.com.senac.remob.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitacaoPassageiro")
public class SolicitaPassageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column 
    private int IdPassageiro;

    @Column
    private int IdSolicitaSuporte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPassageiro() {
        return IdPassageiro;
    }

    public void setIdPassageiro(int idPassageiro) {
        IdPassageiro = idPassageiro;
    }

    public int getIdSolicitaSuporte() {
        return IdSolicitaSuporte;
    }

    public void setIdSolicitaSuporte(int idSolicitaSuporte) {
        IdSolicitaSuporte = idSolicitaSuporte;
    }
}