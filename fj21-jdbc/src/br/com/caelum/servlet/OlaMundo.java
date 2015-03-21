package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ciclo de vida do tomcat
 *  inicia o webserver (tomcat exemplo)
 *  => le o web.xml
 *  => carrega as configuracoes do web.xml
 *  => instancia o servlet descrito no web.xml (servlet.init())
 *  => ativa o servlet para receber e responder as solicitacoes do browser
 *  => destroi a instancia do servlet
 */
public class OlaMundo extends HttpServlet{
	@Override
	protected void service(	HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeiro Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Olá mundo Servlet!</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
