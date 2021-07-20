package br.com.orangetalents.desafioApiRest.DTO;

import br.com.orangetalents.desafioApiRest.Models.Aluno;

public class AlunoDTO {
    private String nome;
    private String email;

    public AlunoDTO(Aluno aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
