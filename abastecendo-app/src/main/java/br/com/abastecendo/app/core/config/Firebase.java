package br.com.abastecendo.app.core.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {

	private static final String FIREBASE_DATABASE_URL = "https://abastecendo-app.firebaseio.com/";

	public static DatabaseReference database;

	public static void init(InputStream serviceAccount) {

		try {

			if (database == null) {
				
				Map<String, Object> auth = new HashMap<String, Object>();
				auth.put("uid", "abastecendo-service");

				FirebaseOptions options = new FirebaseOptions.Builder()
						.setCredentials(GoogleCredentials.fromStream(serviceAccount))
						.setDatabaseUrl(FIREBASE_DATABASE_URL)
						.setDatabaseAuthVariableOverride(auth)
						.build();
				FirebaseApp.initializeApp(options);

				database = FirebaseDatabase.getInstance().getReference("/private_resource");

			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
