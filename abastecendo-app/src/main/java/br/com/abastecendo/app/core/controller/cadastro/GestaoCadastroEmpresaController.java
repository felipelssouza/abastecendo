package br.com.abastecendo.app.core.controller.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.model.cadastro.Usuario;
import br.com.abastecendo.app.core.service.cadastro.GestaoCadastroEmpresaService;

@RestController
@RequestMapping("/empresa")
public class GestaoCadastroEmpresaController {
	
	private final GestaoCadastroEmpresaService gestaoCadastroEmpresaService;

    @Autowired
    public GestaoCadastroEmpresaController(GestaoCadastroEmpresaService gestaoCadastroEmpresaService) {
        this.gestaoCadastroEmpresaService = gestaoCadastroEmpresaService;
    }
    
    @RequestMapping("/cadastrar")
    public @ResponseBody ResponseApi cadastrar(final Usuario usuario) {
    	return gestaoCadastroEmpresaService.cadastrar(usuario);
    }
	
    @RequestMapping("/consultar")
    public @ResponseBody ResponseApi cadastrar(final int codigoUsuario) {
    	return gestaoCadastroEmpresaService.obter(codigoUsuario);
    }
    
    @RequestMapping("/listar")
    public @ResponseBody ResponseApi listar() {
    	return gestaoCadastroEmpresaService.listar();
    }
}
