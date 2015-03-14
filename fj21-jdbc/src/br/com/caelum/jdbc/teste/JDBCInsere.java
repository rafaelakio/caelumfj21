package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			connection = new ConnectionFactory().getConnection();
			System.out.println("Conexão aberta!");
			String sql = "insert into contatos " +
					"(nome, email, endereco, dataNascimento)" +
					" values (?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "Caelum");
			stmt.setString(2, "contato@caelum.com.br");
			stmt.setString(3, "R. Vergueiro 3185 cj57");
			Date dataParaGravar = new Date(Calendar.getInstance().getTimeInMillis());
			stmt.setDate(4, dataParaGravar);
			if (stmt.executeUpdate() > 0) {
				System.out.println("Gravado");
			};
		} catch (SQLException e){
			System.out.println(e);
		} finally {
			connection.close();
		}
	}

}
