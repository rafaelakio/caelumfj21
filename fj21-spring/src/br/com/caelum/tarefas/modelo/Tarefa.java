package br.com.caelum.tarefas.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tarefa {
	private Long id;
	//mensagens cadastradas em ValidationMessages.properties
	@NotNull(message="{tarefa.descricao.nula}")
	@Size(min=5,message="{tarefa.descricao.menos.caracter}")
	private String descricao;
	private boolean finalizado;
	private Calendar dataFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacaoTexto(String dataFinalizacao){
		if(!dataFinalizacao.isEmpty()){
			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(dataFinalizacao);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dataFinalizacao = Calendar.getInstance();
			this.dataFinalizacao.setTime(date);
		}
	}
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

}
