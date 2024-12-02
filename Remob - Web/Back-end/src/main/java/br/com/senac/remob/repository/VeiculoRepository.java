package br.com.senac.remob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.remob.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

}