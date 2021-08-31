package br.com.repositorio.repo.autor;

import br.com.repositorio.repo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorResp {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @Size(max = 400)
    @NotBlank
    private String descricao;

    public AutorResp(@NotBlank String nome, @NotBlank @Email String email, @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorResp(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
