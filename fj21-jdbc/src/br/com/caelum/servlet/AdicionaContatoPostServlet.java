package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EmptyStackException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

@WebServlet(name = "AdicionaContatoPostServlet", urlPatterns = { "/adicionaContatoPost" })
public class AdicionaContatoPostServlet extends HttpServlet {
	@Override
	protected void doPost(	HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
		// busca o writer
		PrintWriter out = response.getWriter();
		
		// buscando os parametros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataNascimentoTexto = request.getParameter("dataNascimento");
		
		// gerando uma excecao para o usuario erroRoot
		if (nome.equals("erroRoot")) { throw new EmptyStackException();}
		
		// fazendo conversao da data
		Calendar dataNascimento = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de convesao da data");
			return; // para a execução do metodo
		}
		
		// incluir no servidor via configuracao o class path do conector mysql
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.setContato(contato);
		
		// imprime o nome do contato que foi adicionado
		out.println("<html><body>");
		out.println("Contato " + contato.getNome() +
				" adicionado com sucesso via POST");
		out.println("</body></html>");
	}
}
