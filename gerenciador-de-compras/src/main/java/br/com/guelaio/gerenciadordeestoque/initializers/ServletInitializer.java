package br.com.guelaio.gerenciadordeestoque.initializers;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.com.guelaio.gerenciadordeestoque.GerenciadorDeEstoqueApplication;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
	return applicationBuilder.sources(GerenciadorDeEstoqueApplication.class);
    }
}
