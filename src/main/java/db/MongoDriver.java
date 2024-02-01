package db;

import java.io.FileInputStream;
import java.util.Properties;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDriver {
	private final String DB_PROPS = "./src/main/res/mrdb.conf";
	private final String DATABASE_NAME = "peripherals";
	private static MongoClient instance = null;
	private static MongoDatabase database = null;

	private MongoDriver() {
		Properties props = new Properties();

		try {
			props.load(new FileInputStream(DB_PROPS));

			instance = MongoClients.create(props.getProperty("PATH"));

			System.out.println("Cliente creado");

			database = instance.getDatabase(DATABASE_NAME);
			System.out.println("Database obtenida");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MongoClient getClient() {
		if (instance == null)
			new MongoDriver();

		return instance;

	}

	public static MongoDatabase getDatabase() {
		if (instance != null)
			return database;

		return null;
	}

}
