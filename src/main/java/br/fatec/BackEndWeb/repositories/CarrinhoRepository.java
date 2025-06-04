package br.fatec.BackEndWeb.repositories;

import br.fatec.BackEndWeb.entities.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
