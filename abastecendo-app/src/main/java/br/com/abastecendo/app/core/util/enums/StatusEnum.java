package br.com.abastecendo.app.core.util.enums;

public enum StatusEnum {
	SUCESSO(200),
	ERRO_NEGOCIO(422),
	ERRO_SERVICO(503);
	
	private int codigo;
	
	StatusEnum(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
}
