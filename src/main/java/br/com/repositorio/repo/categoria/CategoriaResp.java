package br.com.repositorio.repo.categoria;

import br.com.repositorio.repo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaResp {

    private Long id;
    @NotBlank
    private String nome;

    public CategoriaResp(String nome) {
        this.nome = nome;
    }

    public CategoriaResp(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


