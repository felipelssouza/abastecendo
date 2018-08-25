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
import br.com.abastecendo.app.core.service.cadastro.GestaoCadastroEmpresaService;

@RestController
@RequestMapping("/empresa")
public class GestaoCadastroEmpresaController {
	
	private final GestaoCadastroEmpresaService gestaoCadastroEmpresaService;

    @Autowired
    public GestaoCadastroEmpresaController(GestaoCadastroEmpresaService gestaoCadastroEmpresaService) {
        this.gestaoCadastroEmpresaService = gestaoCadastroEmpresaService;
    }
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseApi cadastrar(@RequestBody final Object body)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InterruptedException, ExecutionException {
    	return gestaoCadastroEmpresaService.cadastrar(body);
    }
	
    @RequestMapping(value = "/consultar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseApi consultar(@RequestParam final String id) throws InterruptedException {
    	return gestaoCadastroEmpresaService.consultar(id);
    }
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseApi listar() throws InterruptedException {
    	return gestaoCadastroEmpresaService.listar();
    }
}
