package br.com.abastecendo.app.core.model.cadastro;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8980340759265335797L;

	@JsonProperty("nome")
    private String nome;

    @JsonProperty("tipo_pessoa")
    private String tipoPessoa;

    @JsonProperty("documento")
    private String documento;

    @JsonProperty("perfil_acesso")
    private PerfilAcesso perfilAcesso;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;
    
    @JsonProperty("ativo")
    private boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
    
}
