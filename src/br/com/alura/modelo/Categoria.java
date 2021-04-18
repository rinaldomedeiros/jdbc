package br.com.alura.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(int id, String nome) {

		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adiciona(Produto produto) {
		this.produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}
	
}
