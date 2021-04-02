package br.com.guelaio.gerenciadordeestoque.services;

import br.com.guelaio.gerenciadordeestoque.models.Compra;

public interface CompraService {

    Compra save(Compra compra);
    
    Compra findById(Long compraId);
    
}
