package br.com.repositorio.repo.model;
import br.com.repositorio.repo.livro.LivroReq;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String título;
    @Size(max = 500)
    private String resumo;
    //de tamanho livre. O texto deve entrar no formato markdown,
    // que é uma string. Dessa forma ele pode ser formatado depois da maneira apropriada.
    @NotBlank
    private String sumario;

    @Min(20)
    private double preco;
    @Min(100)
    private Integer numeroDePaginas;

    @NotBlank
    //@ValorExclusivo(domainClass = Livro.class, fieldName = "isbn", message = "isbn precisa ser exclusivo")
    private String isbn;

    @Future
    private LocalDate dataDapublicacao;
    @NotNull
    @ManyToOne
    private Categoria categoria;
    @NotNull
    @ManyToOne
    private Autor autor;

    public Livro(String título, String resumo, String sumario, double preco, Integer numeroDePaginas,
                 String isbn, LocalDate dataDapublicacao, Categoria categoria, Autor autor) {
        this.título = título;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDapublicacao = dataDapublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public long getId() {
        return id;
    }

    public String getTítulo() {
        return título;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDapublicacao() {
        return dataDapublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

}
