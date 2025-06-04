package br.fatec.BackEndWeb.repositories;

import br.fatec.BackEndWeb.entities.ProdutosCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosCarrinhoRepository extends JpaRepository<ProdutosCarrinho, Long> {
}
