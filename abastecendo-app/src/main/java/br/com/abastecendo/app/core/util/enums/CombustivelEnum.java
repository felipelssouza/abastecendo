package br.com.abastecendo.app.core.util.enums;

public enum CombustivelEnum {

	ETANOL(1),
	GASOLINA(2),
	GAS_NATURAL(3),
	DIESEL(4);
	
	private int codigo;
	
	CombustivelEnum(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
}
