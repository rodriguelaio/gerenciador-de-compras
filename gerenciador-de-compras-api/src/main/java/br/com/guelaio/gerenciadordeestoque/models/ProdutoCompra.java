package br.com.guelaio.gerenciadordeestoque.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
//@PrimaryKeyJoinColumn(name = "Produto.id")
public class ProdutoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // (fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "id_compra") // Defino o nome que a coluna de junção terá. O padrão é NOMETABELA_NOMECAMPOPK
    private Compra compra;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_produto") // Defino o nome que a coluna de junção terá. O padrão é NOMETABELA_NOMECAMPOPK
    private Produto produto;

    @Positive
    private double quantidade;

    @Positive
    private double valorUnitarioBruto;

    @PositiveOrZero
    private double valorDesconto;

    @PositiveOrZero
    private double percentualDesconto;

    @Positive
    private double valorUnitarioLiquido;

    @Positive
    private double valorTotalBruto;

    @Positive
    private double valorTotalLiquido;

    public ProdutoCompra() { // O JPA exige construtor padrão vazio

    }

    public ProdutoCompra(Compra compra, Produto produto, double quantidade, double valorUnitarioBruto,
	    double valorDesconto, double percentualDesconto, double valorUnitarioLiquido, double valorTotalBruto,
	    double valorTotalLiquido) {

	setCompra(compra);
	setProduto(produto);
	setQuantidade(quantidade);
	setValorUnitarioBruto(valorUnitarioBruto);
	setValorDesconto(valorDesconto);
	setPercentualDesconto(percentualDesconto);
	setValorUnitarioLiquido(valorUnitarioLiquido);
	setValorTotalBruto(valorTotalBruto);
	setValorTotalLiquido(valorTotalLiquido);
    }

    public long getId() {
	return id;
    }

    public Compra getCompra() {
	return compra;
    }

    private void setCompra(Compra compra) {
	this.compra = compra;
    }

    public Produto getProduto() {
	return produto;
    }

    private void setProduto(Produto produto) {
	this.produto = produto;
    }

    public double getQuantidade() {
	return quantidade;
    }

    private void setQuantidade(double quantidade) {
	this.quantidade = quantidade;
    }

    public double getValorUnitarioBruto() {
	return valorUnitarioBruto;
    }

    private void setValorUnitarioBruto(double valorUnitarioBruto) {
	this.valorUnitarioBruto = valorUnitarioBruto;
    }

    public double getValorDesconto() {
	return valorDesconto;
    }

    private void setValorDesconto(double valorDesconto) {
	this.valorDesconto = valorDesconto;
    }

    public double getPercentualDesconto() {
	return percentualDesconto;
    }

    private void setPercentualDesconto(double percentualDesconto) {
	this.percentualDesconto = percentualDesconto;
    }

    public double getValorUnitarioLiquido() {
	return valorUnitarioLiquido;
    }

    private void setValorUnitarioLiquido(double valorUnitarioLiquido) {
	this.valorUnitarioLiquido = valorUnitarioLiquido;
    }

    public double getValorTotalBruto() {
	return valorTotalBruto;
    }

    private void setValorTotalBruto(double valorTotalBruto) {
	this.valorTotalBruto = valorTotalBruto;
    }

    public double getValorTotalLiquido() {
	return valorTotalLiquido;
    }

    private void setValorTotalLiquido(double valorTotalLiquido) {
	this.valorTotalLiquido = valorTotalLiquido;
    }

}
