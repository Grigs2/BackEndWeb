package br.fatec.BackEndWeb.services;

import br.fatec.BackEndWeb.entities.Carrinho;
import br.fatec.BackEndWeb.entities.Perfil;
import br.fatec.BackEndWeb.repositories.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho cadastrar(Perfil perfil, double total){
        return carrinhoRepository.save(new Carrinho(perfil, total));
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
}
