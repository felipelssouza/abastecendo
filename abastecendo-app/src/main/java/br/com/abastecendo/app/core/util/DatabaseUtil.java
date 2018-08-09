package br.com.abastecendo.app.core.util;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.abastecendo.app.core.config.Firebase;
import br.com.abastecendo.app.core.model.cadastro.Usuario;

@Repository
public class DatabaseUtil {
	
	public void incluir(Object o) {
		Firebase.database.push().setValueAsync(o);
	}
	
	public void alterar(Map<String, Object> atualizar) {
		Firebase.database.updateChildrenAsync(atualizar);
	}
	
	public List<Usuario> listar() {
		return null;
	}

}
