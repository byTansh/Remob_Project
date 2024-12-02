package br.com.senac.remob.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.senac.remob.model.Passageiro;
import br.com.senac.remob.repository.PassageiroRepository;

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
public class PassageiroController {

    private PassageiroRepository passageiroRepository;

    public PassageiroController(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;
    }

    @GetMapping("/passageiro")
    public ResponseEntity<?> pesquisarPassageiros() {
        return new ResponseEntity<>(passageiroRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/passageiro/{id}")
    public ResponseEntity<?> pesquisarPassageirosPorId(@PathVariable int id) {
        return new ResponseEntity<>(passageiroRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/passageiro")
    public ResponseEntity<?> salvarPassageiros(@RequestBody List<Passageiro> entidades) {
        List<Passageiro> cadastrosPassageiros;

        try {
            cadastrosPassageiros = passageiroRepository.saveAll(entidades);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar passageiro", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<Passageiro>>(cadastrosPassageiros, HttpStatus.OK);
    }

    @PutMapping("/motorista")
    public ResponseEntity<?> atualizarPassageiros(@PathVariable int id,
            @RequestBody Passageiro entity) {

        Optional<Passageiro> atualizarPassageiros = passageiroRepository.findById(id);
        Passageiro P = null;

        if (atualizarPassageiros.isPresent()) {
            P = atualizarPassageiros.get();

            P.setNome(entity.getNome());
            P.setCpf(entity.getCpf());
            P.setIdade(entity.getIdade());
            P.setTelefone(entity.getTelefone());
            P.setEmail(entity.getEmail());
            P.setSenha(entity.getSenha());
            P.setSexo(entity.getSexo());

            try {
                P = passageiroRepository.save(P);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao atualizar os dados do passageiro",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Passageiro>(P, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Passageiro não encontrado",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/passageiro/{id}")
    public ResponseEntity<?> exluirPassageiros(@PathVariable int id) {

        Optional<Passageiro> exluirPassageiros = passageiroRepository.findById(id);
        Passageiro P = null;

        if (exluirPassageiros.isPresent()) {
            P = exluirPassageiros.get();

            try {
                passageiroRepository.delete(P);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao excluir os dados do passageiro",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Passageiro>(P, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Motorista não encontrado",
                    HttpStatus.BAD_REQUEST);
        }
    }

}