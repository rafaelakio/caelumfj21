package br.com.caelum.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@WebServlet(name = "FrontControllerServlet", urlPatterns = { "/mvc" })
public class FrontControllerServlet extends HttpServlet{
	
		@Override
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			System.out.println("inicializando o servlet");
			log("inicializando o servlet");
		}
		
		@Override
		protected void service(	HttpServletRequest request,
								HttpServletResponse response)
				throws ServletException, IOException {
			String path = request.getParameter("path");
			String nomeDaClasse = "br.com.caelum.mvc.logica." + path + "Logica";
			try {
				Class classe = Class.forName(nomeDaClasse);
				Logica logica = (Logica) classe.newInstance();
				String pagina = logica.executa(request, response);
				
				request.getRequestDispatcher(pagina).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("A lógica de negócio causou uma exceção", e);
			}
		}
		@Override
		public void destroy() {
			System.out.println("Destruindo o servlet");
			log("Destruindo o servlet");
			super.destroy();
		}
}
