package br.com.abastecendo.app.core.model.cadastro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Veiculo implements Serializable {

	private static final long serialVersionUID = 4006617335025187815L;
	
	@JsonProperty("placa")
	private String placa;
	
	@JsonProperty("marca")
	private String marca;
	
	@JsonProperty("modelo")
	private String modelo;
	
	@JsonProperty("combustivel")
	private int combustivel;
	
	@JsonProperty("usuario")
	private Usuario usuario;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}