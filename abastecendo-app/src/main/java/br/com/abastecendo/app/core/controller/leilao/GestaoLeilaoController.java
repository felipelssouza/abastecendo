package br.com.abastecendo.app.core.controller.leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.service.leilao.GestaoLeilaoService;

@RestController
@RequestMapping("/leilao")
public class GestaoLeilaoController {
	
	private GestaoLeilaoService gestaoLeilaoService;

	@Autowired
	public GestaoLeilaoController(GestaoLeilaoService gestaoLeilaoService) {
		this.gestaoLeilaoService = gestaoLeilaoService;
	}
	
	/***
	 * Registra a participacao de uma empresa em um leilao
	 * @param uidEmpresa
	 * @param body
	 * @return ResponseApi
	 */
	@RequestMapping(value = "/participar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi participar(@RequestBody final Object body) {
		return gestaoLeilaoService.participar(body);
	}
	
	/***
	 * Registra um lance efetuado por uma empresa
	 * @param body
	 * @return ResponseApi
	 */
	@RequestMapping(value = "/lance", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi lance(@RequestBody final Object body) {
		return gestaoLeilaoService.lance(body);
	}
	
	/***
	 *  Retorna os dados do leilao ativo
	 * @return ResponseApi
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/obter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi obter(@RequestParam final String uid) throws InterruptedException {
		return gestaoLeilaoService.obter(uid);
	}
	
	/***
	 * Cancela um leilao que ainda nao foi realizado
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/cancelar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi cancelar(@RequestParam final String uid) {
		return gestaoLeilaoService.cancelar(uid);
	}
	
	/***
	 * Lista os leiloes de acordo com o status selecionado (Todos, Pendentes, Encerrados, Cancelados)
	 * @param status
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi listar(@RequestParam final int status) throws InterruptedException {
		return gestaoLeilaoService.listar(status);
	}
	
	/***
	 * Cria um novo leilao
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/criar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi criar(@RequestBody final Object body) {
		return gestaoLeilaoService.criar(body);
	}
	
	/***
	 * Altera um leilão existente
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/alterar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi alterar(@RequestParam final String uid, @RequestBody final Object body) {
		return gestaoLeilaoService.alterar(uid, body);
	}
}
