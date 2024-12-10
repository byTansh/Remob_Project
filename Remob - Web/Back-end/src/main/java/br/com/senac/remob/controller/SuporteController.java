package br.com.senac.remob.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.senac.remob.model.Suporte;
import br.com.senac.remob.repository.SuporteRepository;

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
public class SuporteController {

    private SuporteRepository suporteRepository;

    public SuporteController(SuporteRepository suporteRepository) {
        this.suporteRepository = suporteRepository;
    }

    @GetMapping("/suporte")
    public ResponseEntity<?> pesquisarSuportes() {
        return new ResponseEntity<>(suporteRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/suporte/{id}")
    public ResponseEntity<?> pesquisarSuportesPorId(@PathVariable int id) {
        return new ResponseEntity<>(suporteRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/suporte")
    public ResponseEntity<?> salvarSuportes(@RequestBody List<Suporte> entidades) {
        List<Suporte> cadastrosSuportes;

        try {
            cadastrosSuportes = suporteRepository.saveAll(entidades);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar solicitação de suporte", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<Suporte>>(cadastrosSuportes, HttpStatus.OK);
    }

    @PutMapping("/suporte")
    public ResponseEntity<?> atualizarSuportes(@PathVariable int id,
            @RequestBody Suporte entity) {

        Optional<Suporte> atualizarSuportes = suporteRepository.findById(id);
        Suporte Sprt = null;

        if (atualizarSuportes.isPresent()) {
            Sprt = atualizarSuportes.get();

            Sprt.setDataAbertura(entity.getDataAbertura());
            Sprt.setStatus(entity.getStatus());
            Sprt.setProtocolo(entity.getProtocolo());
            Sprt.setAssunto(entity.getAssunto());
            Sprt.setConteudo(entity.getConteudo());
    
            try {
                Sprt = suporteRepository.save(Sprt);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao atualizar solicitação de suporte",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Suporte>(Sprt, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Solitação de suporte não encontrado",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/suporte/{id}")
    public ResponseEntity<?> excluirSuportes(@PathVariable int id) {

        Optional<Suporte> excluirSuportes = suporteRepository.findById(id);
        Suporte Sprt = null;

        if (excluirSuportes.isPresent()) {
            Sprt = excluirSuportes.get();

            try {
                suporteRepository.delete(Sprt);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao excluir os solicitação de suporte",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Suporte>(Sprt, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Suporte não encontrado",
                    HttpStatus.BAD_REQUEST);
        }
    }

}