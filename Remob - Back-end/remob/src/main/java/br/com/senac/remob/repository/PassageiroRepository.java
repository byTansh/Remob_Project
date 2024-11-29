package br.com.senac.remob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.remob.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {

}
