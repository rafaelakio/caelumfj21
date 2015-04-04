package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class AlterarContatoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String idRequest = req.getParameter("id");
		Contato contato = new Contato();
		System.out.println(idRequest);
		if(idRequest!=null&&!idRequest.isEmpty()){
			Long id = Long.parseLong(idRequest);
			ContatoDao dao = new ContatoDao();
			contato = dao.getContato(id);
		}
		req.setAttribute("contato", contato);
		return "/altera-contato-mvc.jsp";
	}

}
