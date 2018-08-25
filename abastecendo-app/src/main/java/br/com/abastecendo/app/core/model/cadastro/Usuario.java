package br.com.abastecendo.app.core.model.cadastro;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.abastecendo.app.core.model.leilao.Leilao;
import br.com.abastecendo.app.core.model.pagamento.Pagamento;

public class Usuario extends Pessoa {

	private static final long serialVersionUID = -214162991736936026L;

	@JsonProperty("nome")
    private String nome;
	
	@JsonProperty("pagamento")
	private Pagamento pagamento;
	
	@JsonProperty("pagamentos")
	private List<Pagamento> pagamentos;

	@JsonProperty("veiculo")
	private Veiculo veiculo;
	
	@JsonProperty("leilao")
	private Leilao leilao;
	
	@JsonProperty("leiloes")
	private List<Leilao> leiloes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Leilao> getLeiloes() {
		return leiloes;
	}

	public void setLeiloes(List<Leilao> leiloes) {
		this.leiloes = leiloes;
	}
}
