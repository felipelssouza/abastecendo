package br.com.abastecendo.app.core.model.pagamento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.abastecendo.app.core.model.cadastro.Empresa;
import br.com.abastecendo.app.core.model.cadastro.Usuario;

public class Pagamento implements Serializable{

	private static final long serialVersionUID = -6579094534091842958L;
	
	@JsonProperty("identificacao")
	private String identificacao;
	
	@JsonProperty("usuario")
	private Usuario usuario;
	
	@JsonProperty("empresa")
	private Empresa empresa;

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
