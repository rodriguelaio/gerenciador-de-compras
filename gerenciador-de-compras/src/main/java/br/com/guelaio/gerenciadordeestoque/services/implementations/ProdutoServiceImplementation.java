package br.com.guelaio.gerenciadordeestoque.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guelaio.gerenciadordeestoque.exceptions.ResourceNotFoundException;
import br.com.guelaio.gerenciadordeestoque.models.Produto;
import br.com.guelaio.gerenciadordeestoque.repositories.ProdutoRepository;
import br.com.guelaio.gerenciadordeestoque.services.ProdutoService;

@Service
public class ProdutoServiceImplementation implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto findById(long produtoId) {
	return produtoRepository.findById(produtoId)
		.orElseThrow(() -> new ResourceNotFoundException("Produto não localizado."));
    }

    public List<Produto> findByCategoria(String categoriaDeProduto) {
	return produtoRepository.findByCategoria(categoriaDeProduto)
		.orElseThrow(() -> new ResourceNotFoundException("Nenhum produto localizado."));
    }

    public List<Produto> findAll() {
	return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
	return produtoRepository.save(produto);
    }

    public void deleteById(long produtoId) {
	produtoRepository.deleteById(produtoId);
    }

}
