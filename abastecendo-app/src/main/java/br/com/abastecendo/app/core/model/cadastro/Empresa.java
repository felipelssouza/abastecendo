package br.com.abastecendo.app.core.model.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Empresa extends Pessoa {


	private static final long serialVersionUID = -1975658046543021220L;
	
	@JsonProperty("razao_social")
	private String razaoSocial;
	
	@JsonProperty("fantasia")
	private String fantasia;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

}
