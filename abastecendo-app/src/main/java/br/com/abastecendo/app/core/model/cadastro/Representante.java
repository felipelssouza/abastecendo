package br.com.abastecendo.app.core.model.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Representante extends Pessoa {

	private static final long serialVersionUID = 4792929409879377911L;
	
	@JsonProperty("nome")
    private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
