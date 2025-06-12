package br.fatec.BackEndWeb.services;

import br.fatec.BackEndWeb.entities.Perfil;
import br.fatec.BackEndWeb.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil cadastrar(String nome, String email, String senha, String tipo, String telefone){
        return perfilRepository.save(new Perfil(nome, email, senha, tipo, telefone));
    }

    public Perfil buscarPorId(Long id){
        return perfilRepository.getOne(id);
    }

    public void deletar(Long id){}

    public List<Perfil> listar(){
        return perfilRepository.findAll();
    }
    public String autenticar(String email, String senha){
        Perfil perfil = perfilRepository.autenticacao(email, senha).orElse(null);
        if(perfil != null){
            return perfil.getTipo();
        }else return null;


    }


}
