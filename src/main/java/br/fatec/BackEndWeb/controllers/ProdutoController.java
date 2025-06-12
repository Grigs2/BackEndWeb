package br.fatec.BackEndWeb.controllers;

import br.fatec.BackEndWeb.dtos.ProdutoDTO;
import br.fatec.BackEndWeb.entities.Produto;
import br.fatec.BackEndWeb.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/Listar")
    public Optional<List<Produto>> Listar(){
        return Optional.ofNullable(produtoService.Listar());
    }
    @PostMapping("/Salvar")
    public @ResponseBody String Salvar(@RequestBody ProdutoDTO produto){
       Produto Produto = produtoService.cadastrar(ProdutoDTO.dtoToProduto(produto, false));
       if(Produto == null)
            return "Não foi possivel cadastrar o produto";
       return "Produto cadastrado com sucesso";
    }
}
