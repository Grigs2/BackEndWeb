package br.fatec.BackEndWeb.dtos;

import br.fatec.BackEndWeb.entities.Perfil;

public record PerfilDTO(Long id,
                        String nome,
                        String email,
                        String senha,
                        String telefone,
                        String tipo) {

    public static PerfilDTO perfilToDTO(Perfil perfil) {
        if (perfil!=null) return new PerfilDTO(perfil.getId(), perfil.getNome(), perfil.getEmail(), null, perfil.getTelefone(), perfil.getTipo())
        ; else return null;
    }

    public static Perfil perfilDTOToPerfil(PerfilDTO perfilDTO) {
        if (perfilDTO!=null)return new Perfil(perfilDTO.nome, perfilDTO.email, perfilDTO.senha, perfilDTO.tipo, perfilDTO.telefone)
        ; else return null;
    }
    public static Perfil perfilDTOToPerfil(PerfilDTO perfilDTO, boolean IdExists) {
        if (IdExists)return new Perfil(perfilDTO.id, perfilDTO.nome, perfilDTO.email, perfilDTO.senha, perfilDTO.tipo, perfilDTO.telefone);
        if (perfilDTO!=null)return new Perfil(perfilDTO.nome, perfilDTO.email, perfilDTO.senha, perfilDTO.tipo, perfilDTO.telefone)
                ; else return null;
    }



}
