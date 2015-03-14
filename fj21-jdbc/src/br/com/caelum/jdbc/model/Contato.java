package br.com.caelum.jdbc.model;

import java.util.Calendar;

public class Contato {
	private Long id;
	private String nome;
	private String email;
	private Calendar dataNascimento;
	
	// métodos get e set para id, nome, email, endereço e dataNascimento
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
