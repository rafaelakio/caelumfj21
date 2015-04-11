package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TarefaUsuario {
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataAtualizacao;
	
	@Column(name="login")
	private String login;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
