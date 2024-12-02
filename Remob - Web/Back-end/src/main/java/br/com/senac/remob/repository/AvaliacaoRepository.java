package br.com.senac.remob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.remob.model.AvaliacaoPassageiro;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoPassageiro, Integer> {

}