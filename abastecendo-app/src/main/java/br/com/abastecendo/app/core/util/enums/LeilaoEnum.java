package br.com.abastecendo.app.core.util.enums;

public enum LeilaoEnum {
	AGENDADO(0),
	AGUARDANDO_INICIO(1),
	ENCERRADO(2),
	CANCELADO(3);

	private int codigo;

	LeilaoEnum(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
}
