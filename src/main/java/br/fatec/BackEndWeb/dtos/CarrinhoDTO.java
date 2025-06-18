package br.fatec.BackEndWeb.dtos;

import br.fatec.BackEndWeb.entities.Carrinho;
import br.fatec.BackEndWeb.entities.Perfil;

import java.util.List;

public record CarrinhoDTO(Long id,
                          double total,
                          List<ProdutoDTO> produtos
                          ) {
    public static CarrinhoDTO carrinhoToDTO(Carrinho carrinho) {
        if(carrinho==null)return null;
        List<ProdutoDTO> produtosDTO = carrinho.getProdutosCarrinhos().stream()
                .map(pc -> ProdutoDTO.produtoToDTO(pc.getProduto()))
                .toList();
        return new CarrinhoDTO(carrinho.getId(), carrinho.getTotal(), produtosDTO);
    }
    public static Carrinho carrinhoDTOToCarrinho(CarrinhoDTO carrinhoDTO, Perfil comprador) {
        if(carrinhoDTO==null) return null;
        if(comprador==null) return null;
        if(carrinhoDTO.produtos==null) return null;
        if(carrinhoDTO.produtos.isEmpty()) return null;

        return new Carrinho(comprador, carrinhoDTO.total, ProdutoDTO.ListDTOToProdutoList(carrinhoDTO.produtos));
    }
}
