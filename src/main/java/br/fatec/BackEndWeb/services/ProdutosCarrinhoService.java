package br.fatec.BackEndWeb.services;

import br.fatec.BackEndWeb.entities.Carrinho;
import br.fatec.BackEndWeb.entities.Produto;
import br.fatec.BackEndWeb.entities.ProdutosCarrinho;
import br.fatec.BackEndWeb.repositories.ProdutosCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosCarrinhoService {
    @Autowired
    private ProdutosCarrinhoRepository produtosCarrinhoRepository;

    public ProdutosCarrinho cadastrar(Carrinho carrinho, Produto produto, int quantidade){
        return produtosCarrinhoRepository.save(new ProdutosCarrinho(carrinho, produto, quantidade));
    }
    public List<ProdutosCarrinho> cadastrarProdutos(List<ProdutosCarrinho> produtosCarrinho) {
        if(produtosCarrinho.isEmpty())return null;
        return produtosCarrinhoRepository.saveAll(produtosCarrinho);

    }
}
