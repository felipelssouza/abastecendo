package br.com.abastecendo.app.core.model.api;

public class ResponseApi {
	
	private int status;
	private String mensagem;
	private Object data;
	
	public ResponseApi() {}
	
	public ResponseApi(int status) {
		this.status = status;
	}

	public ResponseApi(int status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}

	public ResponseApi(int status, String mensagem, Object data) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
