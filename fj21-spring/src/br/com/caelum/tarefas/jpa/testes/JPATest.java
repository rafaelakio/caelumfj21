package br.com.caelum.tarefas.jpa.testes;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.caelum.tarefas.modelo.TarefaUsuario;

@RunWith(JMockit.class)
public class JPATest {

	@Test
	public void adicionaTarefaUsuario() {
		TarefaUsuario tu = new TarefaUsuario();
		tu.setDataAtualizacao(Calendar.getInstance());
		tu.setLogin("rafael");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefasUsuarios");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(tu);
		manager.getTransaction().commit();
		
		System.out.println("ID da tarefa: " + tu.getId());
		
		manager.close();
	}
	
	@Test
	public void atualizaTarefa(){
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
	
	@Test
	public void carregaTarefa(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefasUsuarios");
		EntityManager manager = factory.createEntityManager();
		TarefaUsuario tu = manager.find(TarefaUsuario.class, 1L);
		System.out.println(tu.getLogin());
		manager.close();
	}
	
	@Test
	public void geraTabela(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefasUsuarios");
		factory.close();
	}
	
	@Test
	public void removeTarefa(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefasUsuarios");
		EntityManager manager = factory.createEntityManager();
		TarefaUsuario tu = manager.find(TarefaUsuario.class, 1L);
		manager.getTransaction().begin();
		manager.remove(tu);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@Test
	public void buscaTarefas(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefasUsuarios");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select t from TarefaUsuario as t " + 
											"where t.login = :paramLogin");
		
		query.setParameter("paramLogin", "rafael");
		
		List<TarefaUsuario> lista = query.getResultList();
		
		for(TarefaUsuario tu: lista){
			System.out.println(tu.getLogin());
		}
		manager.close();
	}

}
