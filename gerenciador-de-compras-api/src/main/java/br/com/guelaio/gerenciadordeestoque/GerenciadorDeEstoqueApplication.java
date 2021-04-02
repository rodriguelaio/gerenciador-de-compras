package br.com.guelaio.gerenciadordeestoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class GerenciadorDeEstoqueApplication {

    public static void main(String[] args) {
	SpringApplication.run(GerenciadorDeEstoqueApplication.class, args);
    }
}
