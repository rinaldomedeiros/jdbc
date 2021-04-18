package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.alura.dao.ProdutoDAO;
import br.com.alura.modelo.Produto;

public class TestaInsercaoComModelo {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Comoda", "Comoda vertical");

		try (Connection con = new ConnectionFactory().recuperaConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(con);
			produtoDAO.salvar(produto);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
		
//		System.out.println(produto);
	}
}
