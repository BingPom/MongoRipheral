package db;

import java.io.FileInputStream;
import java.util.Properties;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDriver {
	private final String DB_PROPS = "./src/main/res/mrdb.conf";
	private static MongoClient instance = null;

	private MongoDriver() {
		Properties props = new Properties();

		try {
			props.load(new FileInputStream(DB_PROPS));

			instance = MongoClients.create(props.getProperty("PATH"));

			System.out.println("Cliente creado");
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
