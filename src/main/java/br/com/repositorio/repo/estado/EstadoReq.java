package br.com.repositorio.repo.estado;

import br.com.repositorio.repo.config.validacao.ExistsId;
import br.com.repositorio.repo.config.validacao.ValorExclusivo;
import br.com.repositorio.repo.model.Estado;
import br.com.repositorio.repo.model.Pais;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoReq {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @ValorExclusivo(domainClass = Estado.class, fieldName = "nome", message = "Nome precisa ser exclusivo")
    private String nome;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Este país não existe")
    private Long pais;

    public EstadoReq() {
    }

    public Estado conveterParaModel() {
        Estado estado = new Estado(this.nome, this.pais);
        return estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }



}
