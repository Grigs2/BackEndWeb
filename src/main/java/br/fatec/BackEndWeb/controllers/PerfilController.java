package br.fatec.BackEndWeb.controllers;

import br.fatec.BackEndWeb.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Perfil")
public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    @PostMapping("/Salvar/{nome}/{email}/{senha}/{tipo}")
    public @ResponseBody String Salvar(@PathVariable String nome,
                                       @PathVariable String email,
                                       @PathVariable String senha,
                                       @PathVariable String tipo){
        if((perfilService.cadastrar(nome, email, senha, tipo)!=null))
            return "Salvo com sucesso";
        else return "Falha ao salvar";
    }

    @GetMapping("/Autenticar/{email}/{senha}")
    public @ResponseBody String Autenticar(@PathVariable String email,
                                           @PathVariable String senha){
        return perfilService.autenticar(email, senha);
    }
}
