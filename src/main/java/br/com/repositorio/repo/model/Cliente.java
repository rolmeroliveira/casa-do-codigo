package br.com.repositorio.repo.model;

import br.com.repositorio.repo.config.validacao.CpfOuCnpjValido;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CpfOuCnpjValido
    private String documento;//CNPJ ou CPF
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public Cliente(Long id, String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Pais pais, Estado estado, String telefone, String cep) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }


    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Pais pais, Estado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }


}
