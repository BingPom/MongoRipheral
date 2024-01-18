package db;

import java.util.Properties;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDriver {
	private static MongoClient instance = null;

	private MongoDriver() {
		Properties props = new Properties();

		try {
			// props.load(new FileInputStream(DB_PROPS));

			instance = MongoClients.create(); // falta URI
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MongoClient getClient() {
		if (instance == null)
			new MongoDriver();

		return instance;

	}
}
