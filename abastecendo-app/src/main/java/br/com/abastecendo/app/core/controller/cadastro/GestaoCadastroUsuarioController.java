
package br.com.abastecendo.app.core.controller.cadastro;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.service.cadastro.GestaoCadastroUsuarioService;

@RestController
@RequestMapping("/usuario")
public class GestaoCadastroUsuarioController {

	@Autowired
	private final GestaoCadastroUsuarioService gestaoCadastroUsuarioService;

    public GestaoCadastroUsuarioController(GestaoCadastroUsuarioService gestaoCadastroUsuarioService) {
        this.gestaoCadastroUsuarioService = gestaoCadastroUsuarioService;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseApi cadastrar(@RequestBody Object body)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InterruptedException, ExecutionException {
        return gestaoCadastroUsuarioService.incluir(body);
    }

    @RequestMapping(value = "/consultar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseApi obter(@RequestParam String id) throws InterruptedException {
        return gestaoCadastroUsuarioService.consultar(id);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseApi listar() throws InterruptedException {
        return gestaoCadastroUsuarioService.listar();
    }

}
