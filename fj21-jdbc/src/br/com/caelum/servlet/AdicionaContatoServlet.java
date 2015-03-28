package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.EmptyStackException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dto.contato.ContatoFromRequest;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

@WebServlet(name = "AdicionaContatoServlet", urlPatterns = { "/adicionaContato" })
public class AdicionaContatoServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("inicializando o servlet");
		log("inicializando o servlet");
	}
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
			Long idGravado = dao.setContato(contato);
			
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
	@Override
	protected void doGet(	HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
		// busca o writer
		PrintWriter out = response.getWriter();
		try {
			// gerando uma excecao para o usuario erroRoot
			if (request.getParameter("nome").equals("erroRoot")) { throw new EmptyStackException();}
			
			Contato contato = ContatoFromRequest.converteRequestEmContato(request);

			// salva o contato
			ContatoDao dao = new ContatoDao();
			dao.setContato(contato);
			
			// imprime o nome do contato que foi adicionado
			out.println("<html><body>");
			out.println("Contato " + contato.getNome() +
					" adicionado com sucesso via GET");
			out.println("</body></html>");
			
		} catch (ParseException e) {
			out.println("Erro de convesao da data");
			return; // para a execução do metodo
		}
	}
	@Override
	public void destroy() {
		System.out.println("Destruindo o servlet");
		log("Destruindo o servlet");
		super.destroy();
	}
}
