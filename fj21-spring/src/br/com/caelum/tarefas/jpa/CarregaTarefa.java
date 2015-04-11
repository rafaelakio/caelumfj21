package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.TarefaUsuario;

public class CarregaTarefa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefasUsuarios");
		EntityManager manager = factory.createEntityManager();
		TarefaUsuario tu = manager.find(TarefaUsuario.class, 1L);
		System.out.println(tu.getLogin());
		manager.close();

	}

}
