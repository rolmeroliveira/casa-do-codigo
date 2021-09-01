package br.com.repositorio.repo.estado;

import br.com.repositorio.repo.config.validacao.ExistsId;
import br.com.repositorio.repo.config.validacao.ValorExclusivo;
import br.com.repositorio.repo.model.Estado;
import br.com.repositorio.repo.model.Pais;
import javax.validation.constraints.NotBlank;

public class EstadoResp {

    private Long id;
    @NotBlank
    @ValorExclusivo(domainClass = Estado.class, fieldName = "nome", message = "Nome precisa ser exclusivo")
    private String nome;
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Este país não existe")
    private Long pais;


    public EstadoResp(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais();
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Long getPais() {
        return pais;
    }




}


