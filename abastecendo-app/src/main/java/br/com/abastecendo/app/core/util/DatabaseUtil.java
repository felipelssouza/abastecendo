package br.com.abastecendo.app.core.util;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import br.com.abastecendo.app.core.config.Firebase;

@Repository
public class DatabaseUtil {

	private final Logger LOG = Logger.getLogger(DatabaseUtil.class);

	public void incluirComUID(String colecao, Object valor, String uid) {
		Firebase.database.child(colecao).child(uid).setValueAsync(valor);
	}

	public String incluir(String colecao, Object valor) {
		String uid = Firebase.database.child(colecao).push().getKey();
		Firebase.database.child(colecao).child(uid).setValueAsync(valor);
		return uid;
	}
	
	public void incluirEmNoFilho(String colecao, String uid, String noFilho, Map<String, Object> valor) {
		Firebase.database.child(colecao).child(uid).child(noFilho).setValueAsync(valor);
	}

	public void alterar(String colecao, String uid, Map<String, Object> valor) {
		Firebase.database.child(colecao).child(uid).updateChildrenAsync(valor);
	}
	
	public void alterarEmNo(String colecao, String uid, String noFilho, Map<String, Object> valor) {
		Firebase.database.child(colecao).child(uid).child(noFilho).updateChildrenAsync(valor);
	}

	public void listar(String colecao, final ObterDadosListener listener) {

		Firebase.database.child(colecao).addListenerForSingleValueEvent(new ValueEventListener() {

			public void onDataChange(DataSnapshot snapshot) {
				listener.sucesso(snapshot);
			}

			public void onCancelled(DatabaseError error) {
				listener.falha(error);
			}
		});
	}

	public void listarPorCondicao(String colecao, int status, final ObterDadosListener listener) {

		Firebase.database.child(colecao).orderByChild("status").equalTo(status).addListenerForSingleValueEvent(new ValueEventListener() {

			public void onDataChange(DataSnapshot snapshot) {
				listener.sucesso(snapshot);
			}

			public void onCancelled(DatabaseError error) {
				listener.falha(error);
			}
		});

	}

	public void consultar(String colecao, String uid, final ObterDadosListener listener) {

		Firebase.database.child(colecao).child(uid).addListenerForSingleValueEvent(new ValueEventListener() {

			public void onDataChange(DataSnapshot snapshot) {
				listener.sucesso(snapshot);
			}

			public void onCancelled(DatabaseError error) {
				listener.falha(error);
			}
		});
	}

}
