package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class ContatoDaoConsulta {

	public static void main(String[] args) throws SQLException {
		// gera a conexao
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getContatos();
		
		System.out.println("-------------------------");
		System.out.println("Contatos gravados na base");
		System.out.println("-------------------------");
		for(Contato registro:contatos) {
			System.out.println(registro.getNome());
			System.out.println(registro.getEmail());
			System.out.println(registro.getEndereco());
			System.out.println(sdf.format(registro.getDataNascimento().getTime()));
		}
		
		System.out.println("------------------------------------");
		System.out.println("Dados do primeiro contato cadastrado");
		System.out.println("              por id                ");
		System.out.println("------------------------------------");
		Contato contatoConsulta = dao.getContato(1L);
		System.out.println(contatoConsulta.getNome());
		System.out.println(contatoConsulta.getEmail());
		System.out.println(contatoConsulta.getEndereco());
		System.out.println(sdf.format(contatoConsulta.getDataNascimento().getTime()));
		
		
		System.out.println("-----------------------------");
		System.out.println("Dados de contatos cadastrados");
		System.out.println("   com nomes que possuam Ca  ");
		System.out.println("-----------------------------");
		contatos = dao.getContato("Ca");
		for(Contato registro:contatos) {
			System.out.println(registro.getNome());
			System.out.println(registro.getEmail());
			System.out.println(registro.getEndereco());
			System.out.println(sdf.format(registro.getDataNascimento().getTime()));
		}
	}

}
