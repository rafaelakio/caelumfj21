package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dto.contato.ContatoFromRequest;
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
		try {
			
			Contato contato = ContatoFromRequest.converteRequestEmContato(request);
			
			// salva o contato
			ContatoDao dao = new ContatoDao();
			dao.setContato(contato);
			
			// imprime o nome do contato que foi adicionado
			out.println("<html><body>");
			out.println("Contato " + contato.getNome() +
					" adicionado com sucesso via POST");
			out.println("</body></html>");
			
		} catch (ParseException e) {
			out.println("Erro de convesao da data");
			return; // para a execução do metodo
		}
	}
}
