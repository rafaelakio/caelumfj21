package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	/*
	 * http://localhost:8080/fj21-spring/olaMundoSpring
	 */
	@RequestMapping("/olaMundoSpring")
	public String execute(){
		System.out.println("Executando a lógica com Spring MVC");
		return "ok";
	}
}
