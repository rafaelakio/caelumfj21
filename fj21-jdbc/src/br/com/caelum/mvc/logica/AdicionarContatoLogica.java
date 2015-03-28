package br.com.caelum.mvc.logica;

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
		ContatoDao dao = new ContatoDao();
		Long idGravado = dao.setContato(contato);
		req.setAttribute("idCriado", idGravado);
		return "/lista-contatos-mvc.jsp";
	}

}
