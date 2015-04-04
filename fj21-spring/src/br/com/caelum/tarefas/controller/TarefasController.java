package br.com.caelum.tarefas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	/*
	 * criar a tabela de tarefas
	 * create table tarefas ( id BIGINT NOT NULL AUTO_INCREMENT, descricao VARCHAR(255), finalizado BOOLEAN, dataFinalizacao DATE, primary key(id));
	 * 
	 * paginas formatadas atraves do http://getbootstrap.com/css/#forms
	 */
	
	private JdbcTarefaDao dao;
	private List<Tarefa> tarefas = new ArrayList<>();
	private final String _urlPadrao = "tarefas/formulario";
	private final String _urlAdiciona = "tarefas/adiciona";
	private final String _urlLista = "tarefas/lista";
	
	public TarefasController() {
		dao = new JdbcTarefaDao();
	}
	
	@RequestMapping("/tarefas/formulario")
	public String formulario(Tarefa tarefa, Model model){
		if(tarefa!=null&&tarefa.getId()!=null&&tarefa.getId()>0){
			tarefa=dao.buscaPorId(tarefa.getId());
		}
		geraDadosSessao(model, tarefa);
		return _urlAdiciona;
	}
	
	@RequestMapping("/tarefas/adiciona")
	public String adiciona(@Valid Tarefa tarefa, BindingResult br, Model model){
		if(br.hasFieldErrors("descricao")){
			return _urlAdiciona;
		}
		tarefa.setId(dao.adiciona(tarefa));
		geraDadosSessao(model, tarefa);
		return _urlLista;
	}
	
	@RequestMapping("/tarefas/remove")
	public String remove(Tarefa tarefa, Model model){
		dao.remove(tarefa);
		geraDadosSessao(model, tarefa);
		return _urlLista;
	}
	
	@RequestMapping("/tarefas/lista")
	public String lista(Model model){
		geraDadosSessao(model, null);
		return _urlLista;
	}
	
	@RequestMapping("/tarefas/altera")
	public String altera(Tarefa tarefa, Model model){
		dao.altera(tarefa);
		geraDadosSessao(model,tarefa);
		return _urlLista;
	}
	
	@RequestMapping("/tarefas/finaliza")
	public String finaliza(Tarefa tarefa, Model model){
		dao.finaliza(tarefa.getId());
		geraDadosSessao(model,tarefa);
		return _urlLista;
	}
	
	private void geraDadosSessao(Model model,Tarefa tarefa){
		tarefas = dao.lista();
		if(tarefa!=null){
			model.addAttribute("tarefa", tarefa);
		}
		if(tarefas!=null){
			model.addAttribute("tarefas", tarefas);
			if(tarefas.size()>0&&tarefa==null){
				model.addAttribute("tarefa", tarefas.get(0));
			}
		}
	}
}
