package br.com.guelaio.gerenciadordeestoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guelaio.gerenciadordeestoque.enums.CategoriaProduto;
import br.com.guelaio.gerenciadordeestoque.models.Produto;
import br.com.guelaio.gerenciadordeestoque.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produto> findById(@PathVariable long produtoId) {
	return ResponseEntity.ok(produtoService.findById(produtoId));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
	return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/buscarPorCategoria/{categoriaDeProduto}")
    public ResponseEntity<List<Produto>> findByCategoria(@PathVariable CategoriaProduto categoriaDeProduto) {
	return ResponseEntity.ok(produtoService.findByCategoria(categoriaDeProduto));
    }

    @PostMapping
    public ResponseEntity<Produto> save(Produto produto) {
	return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }
}
