package br.com.abastecendo.app.core.model.leilao;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Regiao implements Serializable{

	private static final long serialVersionUID = -7410714802413323397L;
	
	@JsonProperty("zona")
	private int zona;
	
	@JsonProperty("delimitacao")
	private String delimitacao;

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public String getDelimitacao() {
		return delimitacao;
	}

	public void setDelimitacao(String delimitacao) {
		this.delimitacao = delimitacao;
	}

}
