package br.com.repositorio.repo.model;

import org.springframework.orm.jpa.EntityManagerFactoryUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    public Pais() {
    }

    public Pais(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Pais getInstanceById (Long id, EntityManager em){
        Query query = em.createQuery("SELECT 1 FROM Pais  WHERE id = :pCriterioPais");
        query.setParameter("pCriterioPais", id);
        List<Pais> existentes = query.getResultList();
        return existentes.get(0);
    }

    public Pais(String nome) {
        this.nome = nome;
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
}
