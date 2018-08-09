package br.com.abastecendo.app.core.service.cadastro;

import br.com.abastecendo.app.core.model.api.ResponseApi;

public interface GestaoCadastroUsuarioService {

    public ResponseApi incluir(final Object param);
    
    public ResponseApi alterar(final Object param);

    public ResponseApi obter();
    
    public ResponseApi listar();
}
