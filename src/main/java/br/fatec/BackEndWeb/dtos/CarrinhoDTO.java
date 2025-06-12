package br.fatec.BackEndWeb.dtos;

import br.fatec.BackEndWeb.entities.Carrinho;
import br.fatec.BackEndWeb.entities.Perfil;

import java.util.List;

public record CarrinhoDTO(Long id,
                          double total,
                          List<ProdutoDTO> produtos,
                          PerfilDTO Comprador
                          ) {
    public static CarrinhoDTO carrinhoToDTO(Carrinho carrinho) {
        if(carrinho==null)return null;
        List<ProdutoDTO> produtosDTO = carrinho.getProdutosCarrinhos().stream()
                .map(pc -> ProdutoDTO.produtoToDTO(pc.getProduto()))
                .toList();
        return new CarrinhoDTO(carrinho.getId(), carrinho.getTotal(), produtosDTO, PerfilDTO.perfilToDTO(carrinho.getPerfil()));
    }
    public static Carrinho carrinhoDTOToCarrinho(CarrinhoDTO carrinhoDTO) {
        if(carrinhoDTO==null) return null;
        if(carrinhoDTO.Comprador==null) return null;
        if(carrinhoDTO.produtos==null) return null;
        if(carrinhoDTO.produtos.isEmpty()) return null;

        return new Carrinho(PerfilDTO.perfilDTOToPerfil(carrinhoDTO.Comprador, true), carrinhoDTO.total, ProdutoDTO.ListDTOToProdutoList(carrinhoDTO.produtos));
    }
}
