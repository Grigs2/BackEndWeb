package br.fatec.BackEndWeb.services;

import br.fatec.BackEndWeb.dtos.CarrinhoDTO;
import br.fatec.BackEndWeb.entities.Carrinho;
import br.fatec.BackEndWeb.entities.Perfil;
import br.fatec.BackEndWeb.entities.Produto;
import br.fatec.BackEndWeb.entities.ProdutosCarrinho;
import br.fatec.BackEndWeb.repositories.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;


    public Carrinho cadastrarCarrinho(Carrinho carrinho){
        return carrinhoRepository.save(new Carrinho(carrinho.getPerfil(), carrinho.getTotal()));
    }

    public void deletar(Long id){
        carrinhoRepository.deleteById(id);
    }

    public Carrinho buscarPorId(Long id){
        return carrinhoRepository.getOne(id);
    }

    public List<Carrinho> Listar(){
        return carrinhoRepository.findAll();
    }

    public List<Produto> getProdutos(Carrinho carrinho){
        List<Produto> produtos = new ArrayList<>();
        carrinho.getProdutosCarrinhos().forEach(produtoCarrinho -> {
            produtos.add(produtoCarrinho.getProduto());
        });
        return produtos;
    }
}
