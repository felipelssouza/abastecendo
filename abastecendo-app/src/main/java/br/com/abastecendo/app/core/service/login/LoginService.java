package br.com.abastecendo.app.core.service.login;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

import br.com.abastecendo.app.core.model.api.ResponseApi;

public interface LoginService {
	
	public ResponseApi preLogin(Object body)
			throws InterruptedException, ExecutionException, NoSuchAlgorithmException, UnsupportedEncodingException;
	
	public ResponseApi preLoginEmpresa(Object body)
			throws InterruptedException, ExecutionException, NoSuchAlgorithmException, UnsupportedEncodingException;

}
