package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class RemoverContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Long id = Long.parseLong(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDao dao = new ContatoDao((Connection) req.getAttribute("conexao"));
		dao.remove(id);
		req.setAttribute("idExcluido", id);
		List<Contato> contatos = new ContatoDao().getContatos();
		req.setAttribute("contatos", contatos);
		return "/lista-contatos-mvc.jsp";
	}

}
