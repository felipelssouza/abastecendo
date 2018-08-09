package br.com.abastecendo.app.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.DeserializationFeature;

public final class RequestUtil {
	
	private static final ObjectMapper MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	public RequestUtil() {
	}

	public static <T> T getBodyAs(Object origem, Class<T> classDestino) {
		return MAPPER.convertValue(origem, classDestino);
	}

}
