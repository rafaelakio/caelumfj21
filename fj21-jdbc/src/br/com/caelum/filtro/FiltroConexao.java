package br.com.caelum.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.caelum.jdbc.ConnectionFactory;

public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain)
					throws IOException, ServletException {
		//abrido uma conexao
		try {
			System.out.println("entrada do filtro");
			Connection connection = new ConnectionFactory().getConnection();
			
			// pendurando a connection na requisição
			req.setAttribute("conexao", connection);
			
			// executando a servlet
			chain.doFilter(req, res);
			
			// fechando a conexao
			connection.close();
			System.out.println("saida do filtro");
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
