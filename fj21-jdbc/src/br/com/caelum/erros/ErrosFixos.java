package br.com.caelum.erros;

import java.util.EmptyStackException;

import br.com.caelum.servlet.AdicionaContatoServlet;

public class ErrosFixos {
	public static void geraErroAdicionaContato(String nome) 
	throws EmptyStackException
	{
		// gerando uma excecao para o usuario erroRoot
		if (nome.equals("erroRoot")) { throw new EmptyStackException();}
		
		// destroi o servlet caso o usuario seja destroiServlet
		if (nome.equals("destroiServlet")) { new AdicionaContatoServlet().destroy();}
	}
}
