package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.TarefaUsuario;

public class AtualizaTarefa {

	public static void main(String[] args) {
		TarefaUsuario tu = new TarefaUsuario();
		tu.setDataAtualizacao(Calendar.getInstance());
		tu.setLogin("rafael22");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefasUsuarios");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(tu);
		manager.getTransaction().commit();
		
		System.out.println("ID da tarefa: " + tu.getId());
		
		manager.close();
	}

}
