package br.com.guelaio.gerenciadordeestoque.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date data;

    @NotEmpty
    @JsonManagedReference
    @OneToMany(mappedBy = "compra", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProdutoCompra> produtosDaCompra;
    
    public Compra() { // O JPA exige construtor padrão vazio
	
    }
    
    public Compra(Date data, List<ProdutoCompra> produtoCompras) {
	setData(data);
	setProdutosDaCompra(produtoCompras);
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    private void setData(Date data) {
        this.data = data;
    }

    public List<ProdutoCompra> getProdutosDaCompra() {
        return produtosDaCompra;
    }

    private void setProdutosDaCompra(List<ProdutoCompra> produtosDaCompra) {
        this.produtosDaCompra = produtosDaCompra;
    }
}
