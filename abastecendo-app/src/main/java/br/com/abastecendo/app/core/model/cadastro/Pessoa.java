
package br.com.abastecendo.app.core.model.cadastro;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 543366444856767609L;
	
	@JsonProperty("uid")
	private String uid;
	
    @JsonProperty("tipo_pessoa")
    private String tipoPessoa;

    @JsonProperty("documento")
    private String documento;
    
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("senha")
    private String senha;
    
    @JsonProperty("telefone")
    private String telefone;
    
    @JsonProperty("perfil_acesso")
    private PerfilAcesso perfilAcesso;
    
    @JsonProperty("endereco")
    private Endereco endereco;
    
    @JsonProperty("inativo")
    private boolean inativo;
   

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}


}
