package br.com.repositorio.repo.cliente;

import br.com.repositorio.repo.config.validacao.CpfOuCnpjValido;
import br.com.repositorio.repo.config.validacao.ExistsId;
import br.com.repositorio.repo.config.validacao.ValorExclusivo;
import br.com.repositorio.repo.config.validacao.ValidacaoPorMetodo;
import br.com.repositorio.repo.model.Cliente;
import br.com.repositorio.repo.model.Estado;
import br.com.repositorio.repo.model.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteReq {

    private Long id;
    @NotBlank
    @ValorExclusivo(domainClass = Cliente.class, fieldName = "email", message = "email precisa ser exclusivo")
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
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Este país não existe")
    private Long pais;
    private Long estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteReq(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long pais, Long estado, String telefone, String cep) {
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

    /**
     * Converte o cliente deste tipo para o modelo.
     * Precisa do parâmetro em, para poder enviar à calsse que faz a validçãob
     * de país e estado
     */
    public Cliente requestToModel(EntityManager em) {

        /**
         * Verifica se o país tem estados
         * Se o pais tem estados, obriga a informar um estado
         * Se o pais tiver estados e um estado for informado, verifica se o estado é do paaís
         */
        ValidacaoPorMetodo.testaEstado(this.pais, this.estado, em);
        /**
         * Agora vai obter uma instância de país e uma instâcia estado
         */

        Pais pais = Pais.getInstanceById(this.pais, em);
        Estado estado = Estado.getInstanceById(this.estado, em);

        return new Cliente(
        this.email,
        this.nome,
        this.sobrenome,
        this.documento,
        this.endereco,
        this.complemento,
        this.cidade,
        pais,
        estado,
        this.telefone,
        this.cep
        );
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

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
