package br.com.abastecendo.app.core.service.leilao;

import br.com.abastecendo.app.core.model.api.ResponseApi;

public interface GestaoLeilaoService {

	public ResponseApi participar(Object body);

	public ResponseApi lance(Object body);

	public ResponseApi obter(String uid) throws InterruptedException;

	public ResponseApi cancelar(String uid);

	public ResponseApi listar(int status) throws InterruptedException;

	public ResponseApi criar(Object body);

	public ResponseApi alterar(String uid, Object body);

}
