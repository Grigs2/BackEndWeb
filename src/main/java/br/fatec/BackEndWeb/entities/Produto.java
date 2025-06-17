package br.fatec.BackEndWeb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto", schema = "public")
@Data
public class Produto implements Serializable {

    @Serial
    private static final long serialVersionUID = 131232L;
    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_produto", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    public Long id;

    @Column(name = "nome", nullable = false, length = 100)
    public String nome;

    @Column(name = "descricao", nullable = false, length = 255)
    public String descricao;

    @Column(name = "preco", nullable = false)
    public double preco;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonBackReference
    private List<ProdutosCarrinho> produtosCarrinhos = new ArrayList<>();

    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    public Produto(Long id, String nome, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    public Produto(){

    }

}
