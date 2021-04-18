package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException {

		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.execute();

			try (ResultSet rst = stm.getGeneratedKeys()) {
				while (rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		}
	}
	
	public List<Produto> listar() throws SQLException{
		List<Produto> lista = new ArrayList<>();
		
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		
		try (PreparedStatement stm = connection.prepareStatement(sql)){
			stm.execute();
		
			try(ResultSet rs = stm.getResultSet()){
				while(rs.next()) {
					lista.add(new Produto(rs.getInt("ID"), rs.getString("NOME"), rs.getString("DESCRICAO")));
				}
			}
		}
		
		return lista;
		
	}

}
