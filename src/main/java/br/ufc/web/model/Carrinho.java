package br.ufc.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

public class Carrinho {
	 
	private static Carrinho uniqueInstance;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Produto> produtos; 
	
	private Carrinho() {
		 produtos = new ArrayList<Produto>();
	}
	 
	public static Carrinho getInstance() {
		if (Objects.isNull(uniqueInstance))
			uniqueInstance = new Carrinho();
	 
		return uniqueInstance;
	}
	
	public void addProduto(Produto produto){
		produtos.add(produto);
	}
	
	public void removeProduto(Produto produto){
		produtos.remove(produto);
	}
	
	public void clearProdutos(){
		produtos.clear();
	}
	
	public List<Produto> produtos(){
		return this.produtos;
	}
}
