package br.fatec.BackEndWeb.repositories;

import br.fatec.BackEndWeb.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
