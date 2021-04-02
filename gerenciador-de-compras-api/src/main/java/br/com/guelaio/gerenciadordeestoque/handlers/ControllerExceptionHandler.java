package br.com.guelaio.gerenciadordeestoque.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.guelaio.gerenciadordeestoque.exceptions.ResourceNotFoundException;

@ControllerAdvice(basePackages = {"br.com.guelaio.gerenciadordeestoque.controllers"})
public class ControllerExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> ResourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
	return ResponseEntity.badRequest().body(resourceNotFoundException.getMessage());
    }
}
