package br.com.orangetalents.desafioApiRest.Form;

import br.com.orangetalents.desafioApiRest.Models.Aluno;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormCadastroAluno {
    @NotNull @NotEmpty @Length(max = 30)
    private String nome;
    @NotNull @NotEmpty @Length(max = 30)
    private String email;
    @NotNull @Min(18)
    private Integer idade;

    public Aluno converter(){
        return new Aluno(this.nome,this.email,this.idade);
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
