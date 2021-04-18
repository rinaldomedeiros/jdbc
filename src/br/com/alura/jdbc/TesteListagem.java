package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteListagem {

	public static void main(String[] args) throws SQLException {
	
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperaConexao();
		
		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		
		ResultSet rs = stm.getResultSet();
		
		while (rs.next()) {
			Integer id = rs.getInt("ID");
			System.out.println(id);
			String nome = rs.getString("NOME");
			System.out.println(nome);
			String descricao = rs.getString("DESCRICAO");
			System.out.println(descricao);
			
		}
		
	}

}
