package br.com.repositorio.repo.model;

import br.com.repositorio.repo.config.validacao.ValorExclusivo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    @ValorExclusivo(domainClass = Autor.class, fieldName = "email", message = "email precisa ser exclusivo")
    private String email;
    @Size(max = 400)
    private String descricao;
    private LocalDateTime momentoCriacao = LocalDateTime.now();

    public Autor() {
    }

    public Autor(@NotBlank String nome,@NotBlank @Email String email, @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "Autor -> " +
                " Id:  " + id +
                " | Nome:  " + nome +
                " | E-mail: " + email +
                " | Descricao: " + descricao +
                " | Criado em: " + momentoCriacao;
    }
}
