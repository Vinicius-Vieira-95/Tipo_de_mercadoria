package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {
	
	/*
	 * Esse program tem o papel de gerencia quais tipos de produtos são
	 * comun, importado e usados, onde que definido o produto terá um acrescimo
	 * de taxa ou data de fabricação.
	 * 
	 */
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		List<Produto>produtos = new ArrayList<>();
		
		System.out.print("Entre com a quantidade de Mercadoria: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			
			System.out.println("Produto #"+i+" Data");
			System.out.print("Comun/ Usado / Importado :");
			String res = sc.next();
			System.out.print("Nome do Produto:");
			sc.nextLine();
			String nomeDoProduto = sc.nextLine();
			System.out.print("Preço: $");
			Double preco = sc.nextDouble();
			
			if(res.equalsIgnoreCase("Comun")) {
				produtos.add(new Produto(nomeDoProduto, preco));
			}
			else if(res.equalsIgnoreCase("Usado")) {
				System.out.print("Data de fabricação: ");
				Date data = sdf.parse(sc.next());
				produtos.add(new ProdutoUsado(nomeDoProduto, preco, data));
			}
			else if(res.equalsIgnoreCase("Importado")) {
				System.out.print("Acrescente a valor da taxa: $");
				Double taxa = sc.nextDouble();
				produtos.add(new ProdutoImportado(nomeDoProduto, preco, taxa));		
			}	
		}
		
		System.out.println();
		System.out.println("Tags#");
		for(Produto p: produtos) { //mostra os produtos da List.
			System.out.println(p.tagDoProduto());
		}
		
		
		
		
		sc.close();
	}

}
