package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	/*
	 * criar a tabela de tarefas
	 * create table tarefas ( id BIGINT NOT NULL AUTO_INCREMENT, descricao VARCHAR(255), finalizado BOOLEAN, dataFinalizacao DATE, primary key(id));
	 */
	
	HttpServletRequest hr;
	
	@RequestMapping("/tarefas/formulario")
	public String formulario(){
		return "tarefas/formulario";
	}
	
	@RequestMapping("/tarefas/adiciona")
	public String adiciona(Tarefa tarefa){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		Long id = dao.adiciona(tarefa);
		hr.setAttribute("idAtualizado", id);
		return "tarefas/adicionada";
	}
}
