package br.com.guelaio.gerenciadordeestoque.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import br.com.guelaio.gerenciadordeestoque.enums.CategoriaProduto;
import br.com.guelaio.gerenciadordeestoque.enums.UnidadeDeMedida;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @OneToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @NotBlank
    @Column(name = "unidade_medida")
    @Enumerated(EnumType.STRING)
    private UnidadeDeMedida unidadeDeMedida;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @NotNull
    @Positive
    @Column(name = "peso_volume")
    private double pesoVolume;

    public Produto() { // O JPA exige construtor padrão vazio

    }

    public Produto(String nome, Marca marca, UnidadeDeMedida unidadeDeMedida, CategoriaProduto categoria,
	    double pesoVolume) {
	setNome(nome);
	setMarca(marca);
	setUnidadeDeMedida(unidadeDeMedida);
	setCategoria(categoria);
	setPesoVolume(pesoVolume);
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

    public Marca getMarca() {
	return marca;
    }

    private void setMarca(Marca marca) {
	this.marca = marca;
    }

    public UnidadeDeMedida getUnidadeDeMedida() {
	return unidadeDeMedida;
    }

    private void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
	this.unidadeDeMedida = unidadeDeMedida;
    }

    public CategoriaProduto getCategoria() {
	return categoria;
    }

    private void setCategoria(CategoriaProduto categoria) {
	this.categoria = categoria;
    }

    public double getPesoVolume() {
	return pesoVolume;
    }

    private void setPesoVolume(double pesoVolume) {
	this.pesoVolume = pesoVolume;
    }
}
