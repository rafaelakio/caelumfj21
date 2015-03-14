package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.model.Contato;


public class ContatoDao {
	
	private Connection connection;
	private String tabela = "contatos";
	private String sqlInsert = "insert into " + tabela +
				"(nome, email, endereco, dataNascimento)" +
				" values (?, ?, ?, ?)";
	private String sqlUpdate = "update " + tabela +
			" set nome = ?, email = ?, endereco = ?, dataNascimento = ?" +
			" where id = ?";
	private String sqlDelete = "delete from contatos where id = ?";
	private String sqlLista = "select * from " + tabela;
	private String sqlConsultaContato = "select * from " + tabela + " where id = ?";
	private String sqlLikeNome = "select * from " + tabela + " where nome like ?";
		
	public ContatoDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	 
	public Long setContato(Contato contato) throws DAOException {
		PreparedStatement stmt = null;
		Long idAtualizado;
		try {
			if (contato.getId()!=null && !contato.getId().equals(0)) {
				idAtualizado = contato.getId();
				stmt = atualizaContato(contato);
			} else {
				stmt = insereContato(contato);
				ResultSet rs = stmt.getGeneratedKeys();
				rs.next();
				idAtualizado = Long.valueOf(rs.getInt(1));
			}
			stmt.close();
			return idAtualizado;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	private PreparedStatement insereContato(Contato contato)
		throws DAOException {
		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			 
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
			return stmt;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	private PreparedStatement atualizaContato(Contato contato)
		throws DAOException {
			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
				 
				// seta os valores
				stmt.setString(1, contato.getNome());
				stmt.setString(2, contato.getEmail());
				stmt.setString(3, contato.getEndereco());
				stmt.setDate(4, new Date(
						 contato.getDataNascimento().getTimeInMillis()));
				stmt.setLong(5, contato.getId());
				
				// executa
				if (stmt.executeUpdate() > 0) {
					System.out.println("Atualizado");
				}
				return stmt;
			} catch (SQLException e) {
				throw new DAOException(e);
			}
	}
	
	private PreparedStatement removeContato(Long id)
		throws DAOException {
			try {
				// prepared statement para inserção
				PreparedStatement stmt = connection.prepareStatement(sqlDelete);
				 
				// seta os valores
				stmt.setLong(1, id);
				
				// executa
				if (stmt.executeUpdate() > 0) {
					System.out.println("Deletado");
				}
				return stmt;
			} catch (SQLException e) {
				throw new DAOException(e);
			}
	}
	
	public void remove(Long id) throws DAOException {
		PreparedStatement stmt = null;
		try {
			stmt = removeContato(id);
		} 
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	}

	public List<Contato> getContatos() throws DAOException {
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
			 throw new DAOException(e);
		 }
	 }
	
	/*
	 * Consulta por id
	 */
	public Contato getContato(Long id) throws DAOException{
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 Contato contato = null;
		 try {
			 // prepared statement para inserção
			 stmt = connection.prepareStatement(sqlConsultaContato);
			 stmt.setLong(1, id);
			 
			 // executa
			 rs = stmt.executeQuery();
			 if(rs.next()) {
				 contato = createContatoFromResultSet(rs);
			 }
			 stmt.close();
			 return contato;
		 } catch (SQLException e) {
			 throw new DAOException(e);
		 }
	 }
	
	/*
	 * Consulta por nome
	 */
	public List<Contato> getContato(String nome) throws DAOException{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			 // prepared statement para inserção
			 stmt = connection.prepareStatement(sqlLikeNome);
			 stmt.setString(1, "%" + nome + "%");
			 
			 // executa
			 rs = stmt.executeQuery();
			 List<Contato> contatos = createContatosFromResultSet(rs);
			 stmt.close();
			 return contatos;
		 } catch (SQLException e) {
			 throw new DAOException(e);
		 }
	 }
	
	private List<Contato> createContatosFromResultSet(ResultSet rs) throws DAOException {
		List<Contato> lista = new ArrayList<>();
		try {
			 while(rs.next()) {
				 lista.add(createContatoFromResultSet(rs));
			 }
			 return lista;
		 } catch (SQLException e) {
			 throw new DAOException(e);
		 }
	 }
		
	private Contato createContatoFromResultSet(ResultSet rs) throws DAOException {
		try {
			Calendar cal = Calendar.getInstance();
			Contato contato = new Contato();
			contato.setNome(rs.getString("nome"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setEmail(rs.getString("email"));
			cal.setTime(rs.getDate("dataNascimento"));
			contato.setDataNascimento(cal);
			return contato;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	 }
}
