package br.com.senac.remob.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.senac.remob.model.AvaliacaoPassageiro;
import br.com.senac.remob.repository.AvaliacaoRepository;

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
public class AvaliacaoController {

    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoController(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping("/avaliacao")
    public ResponseEntity<?> pesquisarAvaliacoes() {
        return new ResponseEntity<>(avaliacaoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/avaliacao/{id}")
    public ResponseEntity<?> pesquisarAvaliacoesPorId(@PathVariable int id) {
        return new ResponseEntity<>(avaliacaoRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/avaliacao")
    public ResponseEntity<?> salvarAvaliacoes(@RequestBody List<AvaliacaoPassageiro> entidades) {
        List<AvaliacaoPassageiro> cadastrosAvaliacoes;

        try {
            cadastrosAvaliacoes = avaliacaoRepository.saveAll(entidades);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar avaliação", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<AvaliacaoPassageiro>>(cadastrosAvaliacoes, HttpStatus.OK);
    }

    @PutMapping("/avaliacao")
    public ResponseEntity<?> atualizarAvaliacoes(@PathVariable int id,
            @RequestBody AvaliacaoPassageiro entity) {

        Optional<AvaliacaoPassageiro> atualizarAvaliacoes = avaliacaoRepository.findById(id);
        AvaliacaoPassageiro Av = null;

        if (atualizarAvaliacoes.isPresent()) {
            Av = atualizarAvaliacoes.get();

            Av.setComentario(entity.getComentario());
            Av.setNota(entity.getNota());
            Av.setIdViagem(entity.getIdViagem());

            try {
                Av = avaliacaoRepository.save(Av);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao atualizar os dados da avaliação",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<AvaliacaoPassageiro>(Av, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Avaliação não encontrada",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/avaliacao/{id}")
    public ResponseEntity<?> exluirAvaliacoes(@PathVariable int id) {

        Optional<AvaliacaoPassageiro> exluirAvaliacoes = avaliacaoRepository.findById(id);
        AvaliacaoPassageiro Av = null;

        if (exluirAvaliacoes.isPresent()) {
            Av = exluirAvaliacoes.get();

            try {
                avaliacaoRepository.delete(Av);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao excluir os dados da avaliação",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<AvaliacaoPassageiro>(Av, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Avaliação não encontrada",
                    HttpStatus.BAD_REQUEST);
        }
    }

}