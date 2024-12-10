package br.com.senac.remob.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.senac.remob.model.Avaliacao;
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
    public ResponseEntity<?> salvarAvaliacoes(@RequestBody List<Avaliacao> entidades) {
        List<Avaliacao> cadastrosAvaliacoes;

        try {
            cadastrosAvaliacoes = avaliacaoRepository.saveAll(entidades);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar avaliação", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<Avaliacao>>(cadastrosAvaliacoes, HttpStatus.OK);
    }

    @PutMapping("/avaliacao")
    public ResponseEntity<?> atualizarAvaliacoes(@PathVariable int id,
            @RequestBody Avaliacao entity) {

        Optional<Avaliacao> atualizarAvaliacoes = avaliacaoRepository.findById(id);
        Avaliacao Av = null;

        if (atualizarAvaliacoes.isPresent()) {
            Av = atualizarAvaliacoes.get();

            Av.setComentario(entity.getComentario());
            Av.setNota(entity.getNota());

            try {
                Av = avaliacaoRepository.save(Av);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao atualizar os dados da avaliação",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Avaliacao>(Av, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Avaliação não encontrada",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/avaliacao/{id}")
    public ResponseEntity<?> excluirAvaliacoes(@PathVariable int id) {

        Optional<Avaliacao> excluirAvaliacoes = avaliacaoRepository.findById(id);
        Avaliacao Av = null;

        if (excluirAvaliacoes.isPresent()) {
            Av = excluirAvaliacoes.get();

            try {
                avaliacaoRepository.delete(Av);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao excluir os dados da avaliação",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Avaliacao>(Av, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Avaliação não encontrada",
                    HttpStatus.BAD_REQUEST);
        }
    }

}