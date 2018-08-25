package br.com.abastecendo.app.core.model.leilao;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.abastecendo.app.core.model.cadastro.Empresa;
import br.com.abastecendo.app.core.model.cadastro.Usuario;

public class Leilao implements Serializable {

	private static final long serialVersionUID = -566603897867892833L;
	
	@JsonProperty("uid")
	private String uid;

	@JsonProperty("empresa_vencedora")
	private String empresaVencedora;
	
	@JsonProperty("data_inicio")
	private String dataInicio;
	
	@JsonProperty("data_fim")
	private String dataFim;
	
	@JsonProperty("valor_inicial")
	private Double valorInicial;
	
	@JsonProperty("valor_final")
	private Double valorFinal;
	
	@JsonProperty("regiao")
	private Regiao regiao;
	
	@JsonProperty("status")
	private int status;
	
	private List<Lance> lances;
	
	private List<Empresa> empresas;
	
	private List<Usuario> usuarios;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmpresaVencedora() {
		return empresaVencedora;
	}

	public void setEmpresaVencedora(String empresaVencedora) {
		this.empresaVencedora = empresaVencedora;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
