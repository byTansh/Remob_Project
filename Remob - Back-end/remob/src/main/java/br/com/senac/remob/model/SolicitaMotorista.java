package br.com.senac.remob.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "solicitacaoMotorista")
public class SolicitaMotorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column 
    private int IdMotorista;

    @Column
    private int IdSolicitaSuporte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMotorista() {
        return IdMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        IdMotorista = idMotorista;
    }

    public int getIdSolicitaSuporte() {
        return IdSolicitaSuporte;
    }

    public void setIdSolicitaSuporte(int idSolicitaSuporte) {
        IdSolicitaSuporte = idSolicitaSuporte;
    }
}