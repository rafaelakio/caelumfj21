package br.com.caelum.dto.contato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EmptyStackException;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.erros.ErrosFixos;
import br.com.caelum.jdbc.model.Contato;

public class ContatoFromRequest {
	public static Contato converteRequestEmContato(HttpServletRequest request)
		throws ParseException, EmptyStackException
	{
		// buscando os parametros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataNascimentoTexto = request.getParameter("dataNascimento");
		
		// força erros para testes de redirecionamento de pagina
		ErrosFixos.geraErroAdicionaContato(nome);
		
		// fazendo conversao da data
		Calendar dataNascimento = null;
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTexto);
		dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		// incluir no servidor via configuracao o class path do conector mysql
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		return contato;
	}
}
