package br.com.abastecendo.app.core.model.cadastro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Empresa implements Serializable {


	private static final long serialVersionUID = -1975658046543021220L;
	
	@JsonProperty("razao_social")
	private String razaoSocial;
	
	@JsonProperty("nome_fantasia")
	private String nomeFantasia;
	
	@JsonProperty("documento")
    private String documento;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
