package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.model.Contato;


public class ContatoDao {
	
	 private Connection connection;
	 private String tabela = "contatos";
	 private String sqlInsert = "insert into " + tabela +
				"(nome, email, endereco, dataNascimento)" +
				" values (?, ?, ?, ?)";
	 private String sqlLista = "select * from " + tabela;
	 private String sqlConsultaContato = "select * from " + tabela + " where id = ";
		
	 public ContatoDao(){
		 this.connection = new ConnectionFactory().getConnection();
	 }
	 
	 public void setContato(Contato contato) throws SQLException{
		 PreparedStatement stmt = null;
		 try {
			 // prepared statement para inserção
			 stmt = connection.prepareStatement(sqlInsert);
			 
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

	public List<Contato> getContatos() throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			 // prepared statement para inserção
			 stmt = connection.prepareStatement(sqlLista);
			 
			 // executa
			 rs = stmt.executeQuery();
			 List<Contato> contatos = createContatosFromResultSet(rs);
			 stmt.close();
			 return contatos;
		 } catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	 }
	 
	public Contato getContato(Long id) throws SQLException{
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 try {
			 // prepared statement para inserção
			 stmt = connection.prepareStatement(sqlConsultaContato+id);
			 
			 // executa
			 rs = stmt.executeQuery();
			 rs.next();
			 Contato contato = createContatoFromResultSet(rs);
			 stmt.close();
			 return contato;
		 } catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	 }
	
	private List<Contato> createContatosFromResultSet(ResultSet rs) throws SQLException {
		 List<Contato> lista = new ArrayList<Contato>();
		 while(rs.next()) {
			 lista.add(createContatoFromResultSet(rs));
		 }
		 return lista;
	 }

	private Contato createContatoFromResultSet(ResultSet rs) throws SQLException {
		Calendar cal = Calendar.getInstance();
		Contato contato = new Contato();
		contato.setNome(rs.getString("nome"));
		contato.setEndereco(rs.getString("endereco"));
		contato.setEmail(rs.getString("email"));
		cal.setTime(rs.getDate("dataNascimento"));
		contato.setDataNascimento(cal);
		return contato;
	 }
}
