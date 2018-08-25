package br.com.abastecendo.app.core.service.login.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.model.cadastro.Empresa;
import br.com.abastecendo.app.core.model.cadastro.Usuario;
import br.com.abastecendo.app.core.service.login.LoginService;
import br.com.abastecendo.app.core.util.AuthUtil;
import br.com.abastecendo.app.core.util.Constantes;
import br.com.abastecendo.app.core.util.DatabaseUtil;
import br.com.abastecendo.app.core.util.ModelUtil;
import br.com.abastecendo.app.core.util.ObterDadosListener;
import br.com.abastecendo.app.core.util.SenhaUtil;
import br.com.abastecendo.app.core.util.enums.ColecaoEnum;
import br.com.abastecendo.app.core.util.enums.StatusEnum;

@Component
public class LoginServiceImpl implements LoginService {

	private AuthUtil authUtil;
	private DatabaseUtil databaseUtil;
	
	
	@Autowired
	public LoginServiceImpl(AuthUtil authUtil, DatabaseUtil databaseUtil) {
		this.authUtil = authUtil;
		this.databaseUtil = databaseUtil;
	}

	private boolean obteveResposta;
	private Usuario usuario;
	private Empresa empresa;

	@SuppressWarnings("unchecked")
	public ResponseApi preLogin(Object body)
			throws InterruptedException, ExecutionException, NoSuchAlgorithmException, UnsupportedEncodingException {

		Map<String, String> dadosLogin = ModelUtil.getBodyAs(body, Map.class);

		String email = dadosLogin.get("email");
		String senha = dadosLogin.get("senha");

		UserRecord user = authUtil.recuperar(email);

		consultarUsuario(user);

		int tentativas = 0;
		while (!obteveResposta && tentativas < 10) {
			Thread.sleep(100);
			tentativas++;
			System.out.println("***** tentativas:" + tentativas);
		}

		Usuario usuario = recuperaUsuario();

		if (usuario != null && SenhaUtil.valida(senha, usuario.getSenha())) {
			String token = authUtil.gerarToken(user.getUid());
			Map<String, String> mToken = new HashMap<String, String>();
			mToken.put("token", token);
			return new ResponseApi(StatusEnum.SUCESSO.getCodigo(), "", mToken);
		}

		return new ResponseApi(StatusEnum.ERRO_SERVICO.getCodigo(), Constantes.MSG_FALHA_LOGIN_503);
	}
	
	@SuppressWarnings("unchecked")
	public ResponseApi preLoginEmpresa(Object body)
			throws InterruptedException, ExecutionException, NoSuchAlgorithmException, UnsupportedEncodingException {

		Map<String, String> dadosLogin = ModelUtil.getBodyAs(body, Map.class);

		String email = dadosLogin.get("email");
		String senha = dadosLogin.get("senha");

		UserRecord user = authUtil.recuperar(email);

		consultarEmpresa(user);

		int tentativas = 0;
		while (!obteveResposta && tentativas < 10) {
			Thread.sleep(100);
			tentativas++;
			System.out.println("***** tentativas:" + tentativas);
		}

		Empresa empresa = recuperaEmpresa();

		if (empresa != null && SenhaUtil.valida(senha, empresa.getSenha())) {
			String token = authUtil.gerarToken(user.getUid());
			Map<String, String> mToken = new HashMap<String, String>();
			mToken.put("token", token);
			return new ResponseApi(StatusEnum.SUCESSO.getCodigo(), "", mToken);
		}

		return new ResponseApi(StatusEnum.ERRO_SERVICO.getCodigo(), Constantes.MSG_FALHA_LOGIN_503);
	}


	private void consultarUsuario(UserRecord user) throws InterruptedException {

		databaseUtil.consultar(ColecaoEnum.USUARIO.name(), user.getUid(), new ObterDadosListener() {

			public void sucesso(DataSnapshot snapshot) {
				Usuario usuario = snapshot.getValue(Usuario.class);
				confirmaResposta(true, usuario, null);
			}

			public void inicio() {
				// do nothing
			}

			public void falha(DatabaseError error) {
				// TODO Auto-generated method stub
			}
		});

	}
	
	private void consultarEmpresa(UserRecord user) throws InterruptedException {

		databaseUtil.consultar(ColecaoEnum.EMPRESA.name(), user.getUid(), new ObterDadosListener() {

			public void sucesso(DataSnapshot snapshot) {
				Empresa empresa = snapshot.getValue(Empresa.class);
				confirmaResposta(true, null, empresa);
			}

			public void inicio() {
				// do nothing
			}

			public void falha(DatabaseError error) {
				// TODO Auto-generated method stub
			}
		});

	}

	private void confirmaResposta(boolean resposta, Usuario usuario, Empresa empresa) {
		obteveResposta = resposta;
		this.usuario = usuario;
		this.empresa = empresa;
	}

	private Usuario recuperaUsuario() {
		return this.usuario;
	}
	
	private Empresa recuperaEmpresa() {
		return this.empresa;
	}

}
