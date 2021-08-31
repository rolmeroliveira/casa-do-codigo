package br.com.repositorio.repo.autor;

import br.com.repositorio.repo.config.validacao.ValorExclusivo;
import br.com.repositorio.repo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorReq {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @ValorExclusivo(domainClass = Autor.class, fieldName = "email", message = "Email precisa ser exclusivo")
    private String email;
    @Size(max = 400)
    @NotBlank
    private String descricao;

    public AutorReq(@NotBlank String nome, @NotBlank @Email String email, @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor conveterParaModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
