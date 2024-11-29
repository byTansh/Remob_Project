package br.com.senac.remob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.remob.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}