package br.fatec.BackEndWeb.controllers;

import br.fatec.BackEndWeb.dtos.CarrinhoDTO;
import br.fatec.BackEndWeb.entities.Carrinho;
import br.fatec.BackEndWeb.services.CarrinhoService;
import br.fatec.BackEndWeb.services.ProdutosCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ProdutosCarrinhoService produtosCarrinhoService;

    @PostMapping("/FinalizarCompra")
    public @ResponseBody String FinalizarCompra(@RequestBody CarrinhoDTO dto){
            Carrinho Carrinho = CarrinhoDTO.carrinhoDTOToCarrinho(dto);
            if(Carrinho==null) return "Erro ao finalizar compra";
            Carrinho carrinhobd = carrinhoService.cadastrarCarrinho(Carrinho);
            if(carrinhobd==null) return "Erro ao finalizar compra";
            Carrinho.setId(carrinhobd.getId());
            if(produtosCarrinhoService.cadastrarProdutos(Carrinho.getProdutosCarrinhos())==null) return ("Erro ao finaliar compra");
            else return "Compra finalizada com sucesso";
    }
}
