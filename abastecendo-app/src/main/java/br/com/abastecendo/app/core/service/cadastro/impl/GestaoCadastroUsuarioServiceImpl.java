package br.com.abastecendo.app.core.service.cadastro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.model.cadastro.Usuario;
import br.com.abastecendo.app.core.service.cadastro.GestaoCadastroUsuarioService;
import br.com.abastecendo.app.core.util.DatabaseUtil;
import br.com.abastecendo.app.core.util.RequestUtil;
import br.com.abastecendo.app.core.util.StatusCode;

@Component
public class GestaoCadastroUsuarioServiceImpl implements GestaoCadastroUsuarioService {
	
	@Autowired
	private DatabaseUtil databaseUtil;

	public ResponseApi incluir(Object request) {

		Usuario usuario = RequestUtil.getBodyAs(request, Usuario.class);
		
		databaseUtil.incluir(usuario);
		
		ResponseApi response = new ResponseApi(StatusCode.SUCESSO.getStatus());
		
		return response;
	}

	public ResponseApi alterar(Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseApi obter() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseApi listar() {
		List<Usuario> usuarios = databaseUtil.listar();
		ResponseApi response = new ResponseApi(StatusCode.SUCESSO.getStatus());
		response.setData(usuarios);
		return response;
	}

}
