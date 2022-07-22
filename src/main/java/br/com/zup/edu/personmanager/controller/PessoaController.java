package br.com.zup.edu.personmanager.controller;

import br.com.zup.edu.personmanager.PessoaRepository;
import br.com.zup.edu.personmanager.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> removePessoa(@PathVariable Long idPessoa){

        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "não localizado"));

        if (pessoa.comparaData()){
            pessoaRepository.delete(pessoa);
            return ResponseEntity.noContent().build();
        }

        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "não é possivel remover");


    }
}
