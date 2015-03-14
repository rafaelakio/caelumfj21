package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.model.Contato;


public class ContatoDao {
	
	 private Connection connection;
	 private String sql = "insert into contatos " +
				"(nome, email, endereco, dataNascimento)" +
				" values (?, ?, ?, ?)";
		
	 public ContatoDao(){
		 this.connection = new ConnectionFactory().getConnection();
	 }
	 
	 public void adiciona(Contato contato) throws SQLException{
		 PreparedStatement stmt = null;
		 try {
			 // prepared statement para inserção
			 stmt = connection.prepareStatement(sql);
			 
			 // seta os valores
			 stmt.setString(1, contato.getNome());
			 stmt.setString(2, contato.getEmail());
			 stmt.setString(3, contato.getEndereco());
			 stmt.setDate(4, new Date(
					 contato.getDataNascimento().getTimeInMillis()));
			 
			 // executa
			 if (stmt.executeUpdate() > 0) {
				 System.out.println("Gravado");
			 }
		 } catch (SQLException e) {
			 throw new RuntimeException(e);
		 } finally {
			 stmt.close();
		 }
	 }
}
