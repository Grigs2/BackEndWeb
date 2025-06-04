package br.fatec.BackEndWeb.services;

import br.fatec.BackEndWeb.entities.Carrinho;
import br.fatec.BackEndWeb.entities.Produto;
import br.fatec.BackEndWeb.entities.ProdutosCarrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosCarrinhoService {
    @Autowired
    private ProdutoService produtoService;

    public ProdutosCarrinho cadastrar(Carrinho carrinho, Produto produto, int quantidade){
        return new ProdutosCarrinho(carrinho, produto, quantidade);
    }
}
