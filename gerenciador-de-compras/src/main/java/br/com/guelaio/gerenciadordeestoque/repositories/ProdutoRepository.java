package br.com.guelaio.gerenciadordeestoque.repositories;

import br.com.guelaio.gerenciadordeestoque.models.Produto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<List<Produto>> findByCategoria(String categoriaDeProduto);

}
