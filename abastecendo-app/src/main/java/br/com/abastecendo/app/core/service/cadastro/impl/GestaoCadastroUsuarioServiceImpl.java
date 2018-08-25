package br.com.abastecendo.app.core.service.cadastro.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.model.cadastro.Usuario;
import br.com.abastecendo.app.core.service.cadastro.GestaoCadastroUsuarioService;
import br.com.abastecendo.app.core.util.AuthUtil;
import br.com.abastecendo.app.core.util.Constantes;
import br.com.abastecendo.app.core.util.DatabaseUtil;
import br.com.abastecendo.app.core.util.ModelUtil;
import br.com.abastecendo.app.core.util.ObterDadosListener;
import br.com.abastecendo.app.core.util.SenhaUtil;
import br.com.abastecendo.app.core.util.enums.ColecaoEnum;
import br.com.abastecendo.app.core.util.enums.StatusEnum;

@Component
public class GestaoCadastroUsuarioServiceImpl implements GestaoCadastroUsuarioService {

	private DatabaseUtil databaseUtil;
	private AuthUtil authUtil;

	@Autowired
	public GestaoCadastroUsuarioServiceImpl(DatabaseUtil databaseUtil, AuthUtil authUtil) {
		this.databaseUtil = databaseUtil;
		this.authUtil = authUtil;
	}

	private boolean obteveResposta;

	public ResponseApi incluir(final Object requisicao)
			throws InterruptedException, ExecutionException, NoSuchAlgorithmException, UnsupportedEncodingException {

		Usuario usuario = ModelUtil.getBodyAs(requisicao, Usuario.class);

		UserRecord user = authUtil.regristrarUsuario(usuario);
		
		if (user == null) {
			return new ResponseApi(StatusEnum.SUCESSO.getCodigo(), Constantes.MSG_FALHA_CADASTRO_USUARIO_503);
		}
		
		String s = SenhaUtil.cripto(usuario.getSenha());
		usuario.setSenha(s);
		
		databaseUtil.incluirComUID(ColecaoEnum.USUARIO.name(), usuario, user.getUid());

		ResponseApi response = new ResponseApi(StatusEnum.SUCESSO.getCodigo());

		return response;
	}

	public ResponseApi alterar(final Object requisicao) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseApi consultar(final String id) throws InterruptedException {

		int tentativas = 0;
		final List<Usuario> usuarios = new ArrayList<Usuario>();
		obteveResposta = false;

		databaseUtil.consultar(ColecaoEnum.USUARIO.name(), id, new ObterDadosListener() {

			public void inicio() {
				// do nothing
			}

			public void sucesso(DataSnapshot snapshot) {
				Usuario usuario = snapshot.getValue(Usuario.class);
				usuario.setUid(snapshot.getKey());
				usuarios.add(usuario);

				confirmaResposta(true);
			}

			public void falha(DatabaseError error) {
				// TODO Auto-generated method stub
			}
		});

		while (!obteveResposta && tentativas < 10) {
			Thread.sleep(100);
			tentativas++;
			System.out.println("***** tentativas:" + tentativas);
		}
		
		if (usuarios.isEmpty()) {
			ResponseApi response = new ResponseApi(StatusEnum.ERRO_SERVICO.getCodigo());
			response.setMensagem(Constantes.MSG_FALHA_CONSULTA_503);
			return response;
		}

		ResponseApi response = new ResponseApi(StatusEnum.SUCESSO.getCodigo());
		response.setData(usuarios.get(0));
		return response;
	}

	public ResponseApi listar() throws InterruptedException {

		int tentativas = 0;
		final List<Usuario> usuarios = new ArrayList<Usuario>();
		obteveResposta = false;

		databaseUtil.listar(ColecaoEnum.USUARIO.name(), new ObterDadosListener() {

			public void inicio() {
				// do nothing
			}

			public void sucesso(DataSnapshot snapshot) {
				for (DataSnapshot data : snapshot.getChildren()) {
					Usuario usuario = data.getValue(Usuario.class);
					usuario.setUid(data.getKey());
					usuarios.add(usuario);
				}

				confirmaResposta(true);
			}

			public void falha(DatabaseError error) {
				// do nothing
			}
		});

		while (!obteveResposta && tentativas < 10) {

			Thread.sleep(100);
			tentativas++;
			System.out.println("***** tentativas:" + tentativas);
		}
		
		if (usuarios.isEmpty()) {
			ResponseApi response = new ResponseApi(StatusEnum.ERRO_SERVICO.getCodigo());
			response.setMensagem(Constantes.MSG_FALHA_CONSULTA_503);
			return response;
		}

		ResponseApi response = new ResponseApi(StatusEnum.SUCESSO.getCodigo());
		response.setData(usuarios);
		return response;
	}

	private void confirmaResposta(boolean resposta) {
		obteveResposta = resposta;
	}

}
