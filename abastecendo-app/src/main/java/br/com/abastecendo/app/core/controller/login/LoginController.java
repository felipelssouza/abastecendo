package br.com.abastecendo.app.core.controller.login;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.abastecendo.app.core.model.api.ResponseApi;
import br.com.abastecendo.app.core.service.login.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginservice) {
		this.loginService = loginservice;
	}

	@RequestMapping(value = "/pre_login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi preLogin(@RequestBody final Object body)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InterruptedException, ExecutionException {
		return loginService.preLogin(body);
	}
	
	@RequestMapping(value = "/pre_login/empresa", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseApi preLoginEmpresa(@RequestBody final Object body)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InterruptedException, ExecutionException {
		return loginService.preLoginEmpresa(body);
	}


}
