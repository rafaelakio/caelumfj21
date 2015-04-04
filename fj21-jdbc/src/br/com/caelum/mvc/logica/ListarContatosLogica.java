package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class ListarContatosLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ContatoDao dao = new ContatoDao((Connection) req.getAttribute("conexao"));
		List<Contato> contatos = dao.getContatos();
		req.setAttribute("contatos", contatos);
		return "/lista-contatos-mvc.jsp";
	}

}
