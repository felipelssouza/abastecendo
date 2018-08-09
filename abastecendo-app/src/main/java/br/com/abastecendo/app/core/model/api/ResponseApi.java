package br.com.abastecendo.app.core.model.api;

public class ResponseApi {
	
	private int status;
	private String mensagem;
	private Object data;
	
	public ResponseApi() {}
	
	public ResponseApi(int status) {
		this.status = status;
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
