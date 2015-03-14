package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class ContatoDaoAtualizacao {

	public static void main(String[] args) {
		// dados para gravacao
		
		Contato contato = new Contato();
		contato.setId(2L);
		contato.setNome("CaelumDao-Update");
		contato.setEmail("contato-up@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj133");
		contato.setDataNascimento(Calendar.getInstance());
		
		// gera a conexao
		ContatoDao dao = new ContatoDao();
		
		// metodo elegante
		dao.setContato(contato);
		
		System.out.println("Atualizado via ContatoDaoTest");

	}

}
