package br.com.guelaio.gerenciadordeestoque.services;

import java.util.List;

import br.com.guelaio.gerenciadordeestoque.enums.CategoriaProduto;
import br.com.guelaio.gerenciadordeestoque.models.Produto;

public interface ProdutoService {

    Produto findById(long produtoId);

    List<Produto> findByCategoria(CategoriaProduto categoriaDeProduto);

    List<Produto> findAll();

    Produto save(Produto produto);

    void deleteById(long produtoId);

}
