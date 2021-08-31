package br.com.repositorio.repo.livro;

import br.com.repositorio.repo.config.validacao.ExistsId;
import br.com.repositorio.repo.config.validacao.ValorExclusivo;
import br.com.repositorio.repo.model.Autor;
import br.com.repositorio.repo.model.Categoria;
import br.com.repositorio.repo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroReq {

    @NotBlank
    private String título;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    //de tamanho livre. O texto deve entrar no formato markdown,
    // que é uma string. Dessa forma ele pode ser formatado depois da maneira apropriada.
    @NotBlank
    private String sumario;

    @Min(20)
    private Double preco;
    @Min(100)
    private Integer numeroDePaginas;
    //(identificador do livro)
    @NotBlank
    //@ValorExclusivo(domainClass = Livro.class, fieldName = "isbn", message = "isbn precisa ser exclusivo")
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long categoria;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long autor;

    public LivroReq() {
    }

    public LivroReq(String título, String resumo, String sumario, Double reco,
                    Integer numeroDePaginas, String isbn, LocalDate dataPublicacao,
                    Long categoria, Long autor) {
        this.título = título;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }


    /**
     *
     * @apiNote O request só traz strings. Não vi motivo para receber aquium objeto
     * do tipo DateTime. Recebo String, tenho chance de manipular a String e,
     * se for o caso, gerar um objeto adequaod para criar o model
     */
    public Livro formToModel(EntityManager em) {
        Autor autor = em.find(Autor.class,  this.categoria);
        Categoria categoria = em.find(Categoria.class, this.autor);
         new Autor();

        Livro livro = new Livro(
            this.título,
            this.resumo,
            this.sumario,
            this.preco,
            this.numeroDePaginas,
            this.isbn,
            this.dataPublicacao,
            categoria,
            autor
       );
        return livro;
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
        return dataPublicacao;
    }

    public Long getCategoria() {
        return categoria;
    }

    public Long getAutor() {
        return autor;
    }

    //Setters começam aqui. Talvez eu removoa alguns ou todos, depois de testar
    public void setTítulo(String título) {
        this.título = título;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDataDapublicacao(LocalDate dataDapublicacao) {
        this.dataPublicacao = dataDapublicacao;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public void setAutor(Long autor) {
        this.autor = autor;
    }
}


