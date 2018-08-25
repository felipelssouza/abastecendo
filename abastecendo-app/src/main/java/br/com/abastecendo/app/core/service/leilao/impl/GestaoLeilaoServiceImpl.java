package br.com.abastecendo.app.core.service.leilao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.model.leilao.Lance;
import br.com.abastecendo.app.core.model.leilao.Leilao;
import br.com.abastecendo.app.core.service.cadastro.GestaoCadastroEmpresaService;
import br.com.abastecendo.app.core.service.leilao.GestaoLeilaoService;
import br.com.abastecendo.app.core.util.Constantes;
import br.com.abastecendo.app.core.util.DatabaseUtil;
import br.com.abastecendo.app.core.util.ModelUtil;
import br.com.abastecendo.app.core.util.ObterDadosListener;
import br.com.abastecendo.app.core.util.enums.ColecaoEnum;
import br.com.abastecendo.app.core.util.enums.LeilaoEnum;
import br.com.abastecendo.app.core.util.enums.StatusEnum;

@Component
public class GestaoLeilaoServiceImpl implements GestaoLeilaoService {

	private DatabaseUtil databaseUtil;

	@Autowired
	public GestaoLeilaoServiceImpl(DatabaseUtil databaseUtil,
			GestaoCadastroEmpresaService gestaoCadastroEmpresaService) {
		this.databaseUtil = databaseUtil;
	}

	private boolean obteveResposta;

	@SuppressWarnings("unchecked")
	public ResponseApi participar(Object body) {

		Map<String, String> mapDados = ModelUtil.getBodyAs(body, Map.class);
		String leilaoUid = mapDados.get("leilao_uid");
		String emrpesaUid = mapDados.get("empresa_uid");
		
		Map<String, Object> leiloes = new HashMap<String, Object>();
		leiloes.put(leilaoUid, true);
		Map<String, Object> empresas = new HashMap<String, Object>();
		empresas.put(emrpesaUid, true);
		
		// TODO: Mandar um request de atualizacao só com builder
		databaseUtil.alterarEmNo(ColecaoEnum.LEILAO.name(), leilaoUid, "empresas", empresas);
		databaseUtil.alterarEmNo(ColecaoEnum.EMPRESA.name(), emrpesaUid, "leiloes", leiloes);
		
		return new ResponseApi();
	}

	public ResponseApi lance(Object body) {
		
		Lance lance = ModelUtil.getBodyAs(body, Lance.class);
		
		String lanceUid = databaseUtil.incluir(ColecaoEnum.LANCE.name(), lance);
		
		Map<String, Object> mapLance = new HashMap<String, Object>();
		mapLance.put(lanceUid, true);
		
		// TODO: Mandar um request de atualizacao só com builder
		databaseUtil.alterarEmNo(ColecaoEnum.LEILAO.name(), lance.getLeilaoUid(), "lances", mapLance);
		
		return new ResponseApi();
	}

	public ResponseApi cancelar(String uid) {
		
		Map<String, Object> dadosLeilao = new HashMap<String, Object>();
		dadosLeilao.put("status", LeilaoEnum.CANCELADO.getCodigo());
		databaseUtil.alterar(ColecaoEnum.LEILAO.name(), uid, dadosLeilao);
		
		return new ResponseApi();
	}
	
	public ResponseApi obter(String uid) throws InterruptedException {
		
		int tentativas = 0;
		final List<Leilao> leiloes = new ArrayList<Leilao>();
		obteveResposta = false;

		databaseUtil.consultar(ColecaoEnum.LEILAO.name(), uid, new ObterDadosListener() {

			public void inicio() {
				// do nothing
			}

			public void sucesso(DataSnapshot snapshot) {

				Leilao leilao = snapshot.getValue(Leilao.class);
				leilao.setUid(snapshot.getKey());
				leiloes.add(leilao);

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

		if (leiloes.isEmpty()) {
			ResponseApi response = new ResponseApi(StatusEnum.ERRO_SERVICO.getCodigo());
			response.setMensagem(Constantes.MSG_FALHA_CONSULTA_503);
			return response;
		}

		ResponseApi response = new ResponseApi(StatusEnum.SUCESSO.getCodigo());
		response.setData(leiloes);
		return response;
	}

	public ResponseApi listar(int status) throws InterruptedException {

		int tentativas = 0;
		final List<Leilao> leiloes = new ArrayList<Leilao>();
		obteveResposta = false;

		databaseUtil.listarPorCondicao(ColecaoEnum.LEILAO.name(), status, new ObterDadosListener() {

			public void inicio() {
				// do nothing
			}

			public void sucesso(DataSnapshot snapshot) {
				for (DataSnapshot data : snapshot.getChildren()) {
					Leilao leilao = data.getValue(Leilao.class);
					leilao.setUid(data.getKey());
					leiloes.add(leilao);
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

		if (leiloes.isEmpty()) {
			ResponseApi response = new ResponseApi(StatusEnum.ERRO_SERVICO.getCodigo());
			response.setMensagem(Constantes.MSG_FALHA_CONSULTA_503);
			return response;
		}

		ResponseApi response = new ResponseApi(StatusEnum.SUCESSO.getCodigo());
		response.setData(leiloes);
		return response;
	}

	public ResponseApi criar(Object body) {
		Leilao leilao = ModelUtil.getBodyAs(body, Leilao.class);
		databaseUtil.incluir(ColecaoEnum.LEILAO.name(), leilao);
		return new ResponseApi();
	}

	@SuppressWarnings("unchecked")
	public ResponseApi alterar(String uid, Object body) {
		Map<String, Object> dadosLeilao = ModelUtil.getBodyAs(body, Map.class);
		databaseUtil.alterar(ColecaoEnum.LEILAO.name(), uid, dadosLeilao);
		return new ResponseApi();
	}

	private void confirmaResposta(boolean resposta) {
		obteveResposta = resposta;
	}

}
