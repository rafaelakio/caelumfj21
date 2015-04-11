package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {
	
	/*
	 * criar a tabela ==> create table usuarios (login VARCHAR(255), senha VARCHAR(255));
	 */
	
	@RequestMapping("loginForm")
	public String loginForm(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		if(usuario!=null&&!usuario.getLogin().isEmpty()){
			return "foward:tarefas/lista";
		}
		return "login/formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if(new JdbcUsuarioDao().existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:tarefas/lista";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("cadastraLogin")
	public String cadastraLogin(Usuario usuario, HttpSession session) {
		if(new JdbcUsuarioDao().adiciona(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:tarefas/lista";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("login/sair")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:../loginForm";
	}
}
