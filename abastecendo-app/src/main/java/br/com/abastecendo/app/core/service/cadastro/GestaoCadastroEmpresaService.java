package br.com.abastecendo.app.core.service.cadastro;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.model.cadastro.Usuario;

public interface GestaoCadastroEmpresaService {
	
	public ResponseApi cadastrar(Usuario usuario);
	
	public ResponseApi obter(int codigoUsuario);
	
	public ResponseApi listar();

}
