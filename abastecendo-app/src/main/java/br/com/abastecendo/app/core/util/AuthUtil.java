package br.com.abastecendo.app.core.util;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Repository;

import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import br.com.abastecendo.app.core.config.Firebase;
import br.com.abastecendo.app.core.model.cadastro.Empresa;
import br.com.abastecendo.app.core.model.cadastro.Usuario;

@Repository
public class AuthUtil {

	public UserRecord regristrarUsuario(Usuario usuario) throws InterruptedException, ExecutionException {

		CreateRequest request = new CreateRequest()
				.setEmail(usuario.getEmail())
				.setPassword(usuario.getEmail())
				.setDisplayName(usuario.getNome())
				.setDisabled(usuario.isInativo());
		
		UserRecord user = Firebase.firebaseAuth.createUserAsync(request).get();
		
		return user;
	}
	
	public UserRecord regristrarEmpresa(Empresa empresa) throws InterruptedException, ExecutionException {

		CreateRequest request = new CreateRequest()
				.setEmail(empresa.getEmail())
				.setPassword(empresa.getEmail())
				.setDisplayName(empresa.getRazaoSocial())
				.setDisabled(empresa.isInativo());
		
		UserRecord user = Firebase.firebaseAuth.createUserAsync(request).get();
		
		return user;
	}

	public UserRecord recuperar(String email) throws InterruptedException, ExecutionException {
		return Firebase.firebaseAuth.getUserByEmailAsync(email).get();
	}
	
	public String gerarToken(String uid) throws InterruptedException, ExecutionException {
		return Firebase.firebaseAuth.createCustomTokenAsync(uid).get();
	}

}
