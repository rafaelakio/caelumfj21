package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.TarefaUsuario;

public class RemoveTarefa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefasUsuarios");
		EntityManager manager = factory.createEntityManager();
		TarefaUsuario tu = manager.find(TarefaUsuario.class, 1L);
		manager.getTransaction().begin();
		manager.remove(tu);
		manager.getTransaction().commit();
		manager.close();
	}

}
