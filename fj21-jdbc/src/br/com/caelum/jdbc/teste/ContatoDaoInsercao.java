package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class ContatoDaoInsercao {

	public static void main(String[] args) throws SQLException {
		// dados para gravacao
		
		Contato contato = new Contato();
		contato.setNome("CaelumDao");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		// gera a conexao
		ContatoDao dao = new ContatoDao();
		
		// metodo elegante
		Long id = dao.setContato(contato);
		
		System.out.println("Gravado via ContatoDaoTest id = " + id);
	}

}
