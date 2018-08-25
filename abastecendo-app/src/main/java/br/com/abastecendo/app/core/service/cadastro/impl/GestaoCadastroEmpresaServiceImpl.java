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
import br.com.abastecendo.app.core.model.cadastro.Empresa;
import br.com.abastecendo.app.core.service.cadastro.GestaoCadastroEmpresaService;
import br.com.abastecendo.app.core.util.AuthUtil;
import br.com.abastecendo.app.core.util.Constantes;
import br.com.abastecendo.app.core.util.DatabaseUtil;
import br.com.abastecendo.app.core.util.ModelUtil;
import br.com.abastecendo.app.core.util.ObterDadosListener;
import br.com.abastecendo.app.core.util.SenhaUtil;
import br.com.abastecendo.app.core.util.enums.ColecaoEnum;
import br.com.abastecendo.app.core.util.enums.StatusEnum;

@Component
public class GestaoCadastroEmpresaServiceImpl implements GestaoCadastroEmpresaService {

	private DatabaseUtil databaseUtil;
	private AuthUtil authUtil;

	@Autowired
	public GestaoCadastroEmpresaServiceImpl(DatabaseUtil databaseUtil, AuthUtil authUtil) {
		this.databaseUtil = databaseUtil;
		this.authUtil = authUtil;
	}

	private boolean obteveResposta;

	public ResponseApi cadastrar(Object body)
			throws InterruptedException, ExecutionException, NoSuchAlgorithmException, UnsupportedEncodingException {

		Empresa empresa = ModelUtil.getBodyAs(body, Empresa.class);

		UserRecord user = authUtil.regristrarEmpresa(empresa);

		if (user == null) {
			return new ResponseApi(StatusEnum.SUCESSO.getCodigo(), Constantes.MSG_FALHA_CADASTRO_USUARIO_503);
		}

		String s = SenhaUtil.cripto(empresa.getSenha());
		empresa.setSenha(s);

		databaseUtil.incluirComUID(ColecaoEnum.EMPRESA.name(), empresa, user.getUid());

		ResponseApi response = new ResponseApi(StatusEnum.SUCESSO.getCodigo());

		return response;
	}

	public ResponseApi alterar(Object body) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseApi consultar(String uid) throws InterruptedException {
		int tentativas = 0;
		final List<Empresa> empresas = new ArrayList<Empresa>();
		obteveResposta = false;

		databaseUtil.consultar(ColecaoEnum.EMPRESA.name(), uid, new ObterDadosListener() {

			public void inicio() {
				// do nothing
			}

			public void sucesso(DataSnapshot snapshot) {

				Empresa empresa = snapshot.getValue(Empresa.class);
				empresa.setUid(snapshot.getKey());
				empresas.add(empresa);

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

		if (empresas.isEmpty()) {
			ResponseApi response = new ResponseApi(StatusEnum.ERRO_SERVICO.getCodigo());
			response.setMensagem(Constantes.MSG_FALHA_CONSULTA_503);
			return response;
		}

		ResponseApi response = new ResponseApi(StatusEnum.SUCESSO.getCodigo());
		response.setData(empresas);
		return response;
	}

	public ResponseApi listar() throws InterruptedException {
		int tentativas = 0;
		final List<Empresa> empresas = new ArrayList<Empresa>();
		obteveResposta = false;

		databaseUtil.listar(ColecaoEnum.EMPRESA.name(), new ObterDadosListener() {

			public void inicio() {
				// do nothing
			}

			public void sucesso(DataSnapshot snapshot) {
				for (DataSnapshot data : snapshot.getChildren()) {
					Empresa empresa = data.getValue(Empresa.class);
					empresa.setUid(data.getKey());
					empresas.add(empresa);
				}

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

		if (empresas.isEmpty()) {
			ResponseApi response = new ResponseApi(StatusEnum.ERRO_SERVICO.getCodigo());
			response.setMensagem(Constantes.MSG_FALHA_CONSULTA_503);
			return response;
		}

		ResponseApi response = new ResponseApi(StatusEnum.SUCESSO.getCodigo());
		response.setData(empresas);
		return response;
	}

	private void confirmaResposta(boolean resposta) {
		obteveResposta = resposta;
	}
}
