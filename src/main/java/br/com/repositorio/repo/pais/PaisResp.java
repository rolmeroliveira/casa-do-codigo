package br.com.repositorio.repo.pais;

import br.com.repositorio.repo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisResp {

    private Long id;
    @NotBlank
    private String nome;

    public PaisResp(String nome) {
        this.nome = nome;
    }

    public PaisResp(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
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


