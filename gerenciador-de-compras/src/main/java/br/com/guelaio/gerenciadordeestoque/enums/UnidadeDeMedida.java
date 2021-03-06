package br.com.guelaio.gerenciadordeestoque.enums;

public enum UnidadeDeMedida {
    QUILOGRAMA("quilograma"), GRAMA("grama"), LITRO("litro"), MILILITRO("mililitro"), UNIDADE("unidade");
    
    private final String descricao;
    
    UnidadeDeMedida(String descricao) {
	this.descricao = descricao;
    }
    
    public String getDescricao() {
	return this.descricao;
    }
}
