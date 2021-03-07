package br.com.guelaio.gerenciadordeestoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guelaio.gerenciadordeestoque.models.Compra;
import br.com.guelaio.gerenciadordeestoque.services.CompraService;

@RestController
@RequestMapping("/Compra")
public class CompraController {

    @Autowired
    CompraService compraService;
    
    @PostMapping
    public ResponseEntity<Compra> save(@RequestBody Compra compra){
	return ResponseEntity.status(HttpStatus.CREATED).body(compraService.save(compra));
    }
    
    @GetMapping("/{compraId}")
    public ResponseEntity<Compra> findById(@PathVariable long compraId){
	return ResponseEntity.ok().body(compraService.findById(compraId));
    }
    
}
