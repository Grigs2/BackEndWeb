package br.fatec.BackEndWeb.dtos;

import br.fatec.BackEndWeb.entities.Produto;
import br.fatec.BackEndWeb.entities.ProdutosCarrinho;

import java.util.ArrayList;
import java.util.List;

public record ProdutoDTO(Long id, String nome, String descricao, double preco) {

    public static ProdutoDTO produtoToDTO(Produto produto) {
        if(produto!=null)return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco());
        else return null;
    }

    public static Produto dtoToProduto(ProdutoDTO produtoDTO, boolean idExists) {
        if(idExists)return new Produto(produtoDTO.id, produtoDTO.nome, produtoDTO.descricao, produtoDTO.preco);
        if(produtoDTO!=null)return new Produto(produtoDTO.nome, produtoDTO.descricao, produtoDTO.preco);
        else return null;
    }
    public static List<Produto> ListDTOToProdutoList(List<ProdutoDTO> produtoDTOS) {
        if (produtoDTOS==null)return null;
        List<Produto> produtos = new ArrayList<>();
        produtoDTOS.forEach(produtoDTO -> produtos.add(dtoToProduto(produtoDTO, true)));
        return produtos;
    }
}
