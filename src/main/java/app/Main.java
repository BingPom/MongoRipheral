package app;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import db.MongoDriver;
import model.Peripheral;

public class Main {

	public static void main(String[] args) {
		MongoClient client = MongoDriver.getClient();
		MongoDatabase database = MongoDriver.getDatabase();
		
		//client.getDatabase("MongoRipheral");

		Peripheral test = new Peripheral("id", "nombre del cacharro", 100.0, "descripcion describiendo el cacharro",
				"marca de perifericos");
		System.out.println(test.toString());

	}

}
