package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //definir formato da data
	
	private Date dataDeFabricacao;

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preço, Date dataDeFabricacao) {
		super(nome, preço);
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public Date getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(Date dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}
	
	@ Override
	public String tagDoProduto() { //sobre-escrita
		return getNome() +" (usado) $" 
				+ String.format("%.2f", getPreço())+ ", Data: " 
				+ sdf.format(dataDeFabricacao);
	}
	

}
