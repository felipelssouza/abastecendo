package br.com.abastecendo.app.core.config;

import java.io.InputStream;

import org.springframework.web.servlet.DispatcherServlet;

public class ServletConfig extends DispatcherServlet {

	private static final long serialVersionUID = -2091859401927320399L;

	private static final String ADMIN_SERVICE_ACCOUNT = "abastecendo-app-aff8bf7a2e1c.json";

	public ServletConfig() {

		InputStream is = getClass()
				.getClassLoader()
				.getResourceAsStream(ADMIN_SERVICE_ACCOUNT);

		Firebase.init(is);
	}

}
