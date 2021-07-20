package br.com.orangetalents.desafioApiRest.Repository;

import br.com.orangetalents.desafioApiRest.Models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
