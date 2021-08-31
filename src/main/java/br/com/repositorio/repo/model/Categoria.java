package br.com.repositorio.repo.model;

import br.com.repositorio.repo.config.validacao.ValorExclusivo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @ValorExclusivo(domainClass = Categoria.class, fieldName = "email", message = "Nome precisa ser exclusivo")
    private String nome;

    /**
     * Normalmente não seria necessário este construtor em branco
     * mas a validação UniqueValue não roda sem ele
     */
    public Categoria() {

    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Categoria -> " +
                " Id:  " + id +
                " | Nome:  " + nome;
    }
}
