package br.com.abastecendo.app.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SenhaUtil {
	
	public static String cripto(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		MessageDigest algo = MessageDigest.getInstance("SHA-1");
		byte digest [] = algo.digest(s.getBytes("UTF-8"));
		
		StringBuffer hex = new StringBuffer();
		for (byte b : digest) {
			hex.append(String.format("%02X", 0xFF & b));
		}
		
		return hex.toString();
	}

	public static boolean valida(String s, String sCompara) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return sCompara.equals(cripto(s));
	}
}
