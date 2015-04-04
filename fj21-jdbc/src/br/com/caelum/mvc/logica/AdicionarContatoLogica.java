package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dto.contato.ContatoFromRequest;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class AdicionarContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Contato contato = ContatoFromRequest.converteRequestEmContato(req);
		// salva o contato
		ContatoDao dao = new ContatoDao((Connection) req.getAttribute("conexao"));
		Long idGravado = dao.setContato(contato);
		req.setAttribute("idCriado", idGravado);
		List<Contato> contatos = new ContatoDao().getContatos();
		req.setAttribute("contatos", contatos);
		return "/lista-contatos-mvc.jsp";
	}

}
