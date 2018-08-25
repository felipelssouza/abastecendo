package br.com.abastecendo.app.core.model.leilao;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lance implements Serializable{

	private static final long serialVersionUID = 1191706427203468734L;
	
	@JsonProperty("uid")
	private String uid;
	
	@JsonProperty("leilao_uid")
	private String leilaoUid;
	
	@JsonProperty("empresa_uid")
	private String empresaUid;
	
	@JsonProperty("valor")
	private Double valor;
	
	@JsonProperty("timestamp")
	private String timestamp;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getLeilaoUid() {
		return leilaoUid;
	}

	public void setLeilaoUid(String leilaoUid) {
		this.leilaoUid = leilaoUid;
	}

	public String getEmpresaUid() {
		return empresaUid;
	}

	public void setEmpresaUid(String empresaUid) {
		this.empresaUid = empresaUid;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
