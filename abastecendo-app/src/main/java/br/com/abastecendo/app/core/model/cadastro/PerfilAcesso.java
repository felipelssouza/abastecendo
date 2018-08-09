package br.com.abastecendo.app.core.model.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PerfilAcesso implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3039534600315140529L;

	@JsonProperty("codigo")
    private int codigo;

    @JsonProperty("descricao")
    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
