package entities;

public class ProdutoImportado extends Produto {

	private Double taxaPersonalizada;
	
	public ProdutoImportado() {
		super();
	}

	public ProdutoImportado(String nome, Double pre�o, Double taxaPersonalizada) {
		super(nome, pre�o);
		this.taxaPersonalizada = taxaPersonalizada;
	}

	public Double getTaxaPersonalizada() {
		return taxaPersonalizada;
	}

	public void setTaxaPersonalizada(Double taxaPersonalizada) {
		this.taxaPersonalizada = taxaPersonalizada;
	}
	
	public double precoTotal() { //acrescimo da taxa com valor do produto.
		return getPre�o() + taxaPersonalizada;
	}
	
	@ Override
	public final String tagDoProduto() { //sobre-escrita
		return super.tagDoProduto()+" Taxa: $"+ String.format("%.2f", taxaPersonalizada)
		+ " Total:  $"+ String.format("%.2f", precoTotal());
	}
	
	
}
