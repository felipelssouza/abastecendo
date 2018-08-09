package br.com.abastecendo.app.core.util;

public enum StatusCode {
	SUCESSO(200),
	ERRO_NEGOCIO(422),
	ERRO_SERVICO(503);
	
	private int status;
	
	StatusCode(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}
