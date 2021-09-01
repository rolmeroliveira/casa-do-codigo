package br.com.repositorio.repo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @NotNull
    private Long pais;

    public Estado(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado(Long id, String nome, Long pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPais() {
        return pais;
    }


}
