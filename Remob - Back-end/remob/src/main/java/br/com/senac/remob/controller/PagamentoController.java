package br.com.senac.remob.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.senac.remob.model.Pagamento;
import br.com.senac.remob.repository.PagamentoRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class PagamentoController {

    private PagamentoRepository pagamentoRepository;

    public PagamentoController(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @GetMapping("/pagamento")
    public ResponseEntity<?> pesquisarPagamentos() {
        return new ResponseEntity<>(pagamentoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/pagamento/{id}")
    public ResponseEntity<?> pesquisarPagamentosPorId(@PathVariable int id) {
        return new ResponseEntity<>(pagamentoRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/pagamento")
    public ResponseEntity<?> salvarPagamentos(@RequestBody List<Pagamento> entidades) {
        List<Pagamento> cadastrosPagamentos;

        try {
            cadastrosPagamentos = pagamentoRepository.saveAll(entidades);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar pagamento", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<Pagamento>>(cadastrosPagamentos, HttpStatus.OK);
    }

    @PutMapping("/pagamento")
    public ResponseEntity<?> atualizarPagamentos(@PathVariable int id,
            @RequestBody Pagamento entity) {

        Optional<Pagamento> atualizarPagamentos = pagamentoRepository.findById(id);
        Pagamento Pa = null;

        if (atualizarPagamentos.isPresent()) {
            Pa = atualizarPagamentos.get();

            Pa.setValorTotal(entity.getValorTotal());
            Pa.setFormaPagamento(entity.getFormaPagamento());
            Pa.setIdPassageiro(entity.getIdPassageiro());
            Pa.setIdMotorista(entity.getIdMotorista());
            Pa.setIdViagem(entity.getIdViagem());

            try {
                Pa = pagamentoRepository.save(Pa);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao atualizar os dados do pagamento",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Pagamento>(Pa, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Pagamento não encontrada",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/pagemento/{id}")
    public ResponseEntity<?> exluirPagamentos(@PathVariable int id) {

        Optional<Pagamento> exluirPagamentos = pagamentoRepository.findById(id);
        Pagamento Pa = null;

        if (exluirPagamentos.isPresent()) {
            Pa = exluirPagamentos.get();

            try {
                pagamentoRepository.delete(Pa);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao excluir os dados do pagamento",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Pagamento>(Pa, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Pagamento não encontrada",
                    HttpStatus.BAD_REQUEST);
        }
    }

}