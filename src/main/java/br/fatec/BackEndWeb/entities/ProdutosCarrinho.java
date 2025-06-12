package br.fatec.BackEndWeb.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.util.List;

@Entity
@Table(name = "produtos_carrinho", schema = "public")
@Data

public class ProdutosCarrinho implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 12313L;

    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_produtos_carrinho", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    private Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public ProdutosCarrinho(Carrinho carrinho, Produto produto, int quantidade) {
        setCarrinho(carrinho);
        setProduto(produto);
        setQuantidade(quantidade);
    }



}
