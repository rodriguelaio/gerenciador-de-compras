package br.com.guelaio.gerenciadordeestoque.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guelaio.gerenciadordeestoque.exceptions.ResourceNotFoundException;
import br.com.guelaio.gerenciadordeestoque.models.Compra;
import br.com.guelaio.gerenciadordeestoque.repositories.CompraRepository;
import br.com.guelaio.gerenciadordeestoque.services.CompraService;

@Service
public class CompraServiceImplementation implements CompraService {

    @Autowired
    CompraRepository compraRepository;

    @Override
    public Compra save(Compra compra) {
	compraRepository.save(compra);
	return findById(compra.getId());
    }

    @Override
    public Compra findById(Long compraId) {
	return compraRepository.findById(compraId)
		.orElseThrow(() -> new ResourceNotFoundException("Compra não localizada"));
    }

}
