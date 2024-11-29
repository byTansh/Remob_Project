package br.com.senac.remob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.remob.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Integer> {

}