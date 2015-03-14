package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class ContatoDaoRemocao {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// dados para gravacao
		Contato contato = new Contato();
		contato.setNome("CaelumDao-Delecao");
		contato.setEmail("contato-delecao@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj199");
		contato.setDataNascimento(Calendar.getInstance());
		
		// gera a conexao		
		ContatoDao dao = new ContatoDao();
		
		Long id = dao.setContato(contato);
		
		// verificao antes da remocao
		System.out.println("---------------------------");
		System.out.println("Dados do contato cadastrado");
		System.out.println("     antes da remocao      ");
		System.out.println("---------------------------");
		Contato contatoConsulta = dao.getContato(id);
		System.out.println(contatoConsulta.getNome());
		System.out.println(contatoConsulta.getEmail());
		System.out.println(contatoConsulta.getEndereco());
		System.out.println(sdf.format(contatoConsulta.getDataNascimento().getTime()));
		
		// delecao do registro gerado
		dao.remove(id);
		
		// verificacao apos remocao
		System.out.println("---------------------------");
		System.out.println("Dados do contato cadastrado");
		System.out.println("    depois da remocao      ");
		System.out.println("---------------------------");
		contatoConsulta = dao.getContato(id);
		System.out.println(contatoConsulta.getNome());
		System.out.println(contatoConsulta.getEmail());
		System.out.println(contatoConsulta.getEndereco());
		System.out.println(sdf.format(contatoConsulta.getDataNascimento().getTime()));
	}

}
