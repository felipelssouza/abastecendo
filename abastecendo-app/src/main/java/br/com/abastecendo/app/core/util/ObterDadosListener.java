package br.com.abastecendo.app.core.util;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public interface ObterDadosListener {
	
	public void inicio();
	public void sucesso(DataSnapshot snapshot);
	public void falha(DatabaseError error);
}
