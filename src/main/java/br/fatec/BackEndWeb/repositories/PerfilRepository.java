package br.fatec.BackEndWeb.repositories;

import br.fatec.BackEndWeb.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    @Query(value = "SELECT p FROM Perfil p " + "WHERE p.email=:email AND p.senha=:senha")
    Optional<Perfil> autenticacao(String email, String  senha);

}
