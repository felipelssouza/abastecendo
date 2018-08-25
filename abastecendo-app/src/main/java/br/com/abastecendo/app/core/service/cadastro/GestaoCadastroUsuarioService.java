package br.com.abastecendo.app.core.service.cadastro;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

import br.com.abastecendo.app.core.model.api.ResponseApi;

public interface GestaoCadastroUsuarioService {

    public ResponseApi incluir(final Object body) throws InterruptedException, ExecutionException, NoSuchAlgorithmException, UnsupportedEncodingException;
    
    public ResponseApi alterar(final Object body);

    public ResponseApi consultar(final String id) throws InterruptedException;
    
    public ResponseApi listar() throws InterruptedException;
}
