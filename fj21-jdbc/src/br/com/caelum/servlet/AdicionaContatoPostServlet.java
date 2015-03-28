package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
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
			/* codigo comentado conforme explicacao abaixo
			out.println("<html><body>");
			out.println("Contato " + contato.getNome() +
					" adicionado com sucesso via POST");
			out.println("</body></html>");
			 */
			
			// ao inves de usar o metodo anterior, redirecionaremos a pagina para uma jsp ja existente
			/* codigo comentado conforme explicacao abaixo
			RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-body.jsp");
			rd.forward(request, response);
			 * */
			// o metodo acima, realiza o redirecionamento internamente no server-side
			// para realizar a alteracao no browser (client side) deve-se utilizar o response conforme abaixo:
			System.out.println("entrando no send Redirect");
			response.sendRedirect("lista-contatos-body.jsp");
		} catch (ParseException e) {
			out.println("Erro de convesao da data");
			return; // para a execução do metodo
		}
	}
}
