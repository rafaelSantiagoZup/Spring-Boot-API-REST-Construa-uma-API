package br.com.orangetalents.desafioApiRest.Controller;

import br.com.orangetalents.desafioApiRest.DTO.AlunoDTO;
import br.com.orangetalents.desafioApiRest.Form.FormCadastroAluno;
import br.com.orangetalents.desafioApiRest.Models.Aluno;
import br.com.orangetalents.desafioApiRest.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhes(@PathVariable Long id){
        Optional<Aluno> aluno = repository.findById(id);
        if(aluno.isPresent()){
            return ResponseEntity.ok(new AlunoDTO(aluno.get()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AlunoDTO> adicionaAluno(@RequestBody @Valid FormCadastroAluno cadastro, UriComponentsBuilder uriBuilder){
        Aluno aluno = cadastro.converter();
        repository.save(aluno);

        URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDTO(aluno));
    }
}
