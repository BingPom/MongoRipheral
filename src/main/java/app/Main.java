package app;

import com.mongodb.client.MongoClient;

import db.MongoDriver;

public class Main {

	public static void main(String[] args) {
		MongoClient client = MongoDriver.getClient();

		client.getDatabase("MongoRipheral");
	}

}
