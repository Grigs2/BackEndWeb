package br.fatec.BackEndWeb.services;

import br.fatec.BackEndWeb.entities.Produto;
import br.fatec.BackEndWeb.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrar(String nome, String descricao, double valor){
        return produtoRepository.save(new Produto(nome, descricao, valor));
    }

    public void deletar(Long id){}

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElse(null);
    }
    public List<Produto> Listar(){
        return produtoRepository.findAll();
    }
}
