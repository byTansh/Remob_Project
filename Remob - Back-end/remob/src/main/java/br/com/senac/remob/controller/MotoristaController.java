package br.com.senac.remob.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.senac.remob.model.Motorista;
import br.com.senac.remob.repository.MotoristaRepository;

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
public class MotoristaController {

    private MotoristaRepository motoristaRepository;

    public MotoristaController(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    @GetMapping("/motorista")
    public ResponseEntity<?> pesquisarMotoristas() {
        return new ResponseEntity<>(motoristaRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/motorista/{id}")
    public ResponseEntity<?> pesquisarMotoristasPorId(@PathVariable int id) {
        return new ResponseEntity<>(motoristaRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/motorista")
    public ResponseEntity<?> salvarMotoristas(@RequestBody List<Motorista> entidades) {
        List<Motorista> cadastrosMotoristas;

        try {
            cadastrosMotoristas = motoristaRepository.saveAll(entidades);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar motorista", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<List<Motorista>>(cadastrosMotoristas, HttpStatus.OK);
    }

    @PutMapping("/motorista/{id}")
    public ResponseEntity<?> atualizarMotoristas(@PathVariable int id,
            @RequestBody Motorista entity) {

        Optional<Motorista> atualizarMotoristas = motoristaRepository.findById(id);
        Motorista M = null;

        if (atualizarMotoristas.isPresent()) {
            M = atualizarMotoristas.get();

            M.setCnh(entity.getCnh());
            M.setRg(entity.getRg());
            M.setIdVeiculo(entity.getIdVeiculo());
            M.setIdViagem(entity.getIdViagem());
            M.setCpf(entity.getCpf());
            M.setEmail(entity.getEmail());
            M.setNome(entity.getNome());
            M.setSenha(entity.getSenha());
            M.setTelefone(entity.getTelefone());
            M.setSexo(entity.getSexo());
            M.setIdade(entity.getIdade());

            try {
                M = motoristaRepository.save(M);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao atualizar os dados do motorista",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Motorista>(M, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Motorista não encontrado",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/motorista/{id}")
    public ResponseEntity<?> exluirMotoristas(@PathVariable int id) {

        Optional<Motorista> exluirMotoristas = motoristaRepository.findById(id);
        Motorista M = null;

        if (exluirMotoristas.isPresent()) {
            M = exluirMotoristas.get();

            try {
                motoristaRepository.delete(M);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao excluir os dados do motorista",
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Motorista>(M, HttpStatus.OK);

        } else {
            return new ResponseEntity<String>("Motorista não encontrado",
                    HttpStatus.BAD_REQUEST);
        }
    }

}