package br.com.guelaio.gerenciadordeestoque.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    public Marca() {

    }

    public Marca(String nome) {
	setNome(nome);
    }

    public long getId() {
	return id;
    }

    public String getNome() {
	return nome;
    }

    private void setNome(String nome) {
	this.nome = nome;
    }

}
