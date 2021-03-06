package br.com.guelaio.gerenciadordeestoque.repositories;

import br.com.guelaio.gerenciadordeestoque.models.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
