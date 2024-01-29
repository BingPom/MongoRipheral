package controller;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import db.MongoDriver;
import model.Peripheral;

public class KeyboardController implements PeripheralController {
	private static final String COLLECTION_NAME = "keyboards";
	private MongoCollection<Document> collection;

	public KeyboardController() {
		this.collection = MongoDriver.getDatabase().getCollection(COLLECTION_NAME);
	}

	public void insert(Peripheral peripheral) {
		Document doc = new Document().append("name", peripheral.getName()).append("price", peripheral.getPrice())
				.append("description", peripheral.getDescription()).append("brand", peripheral.getBrand());

		collection.insertOne(doc);
	}

	public void update(String name, Peripheral updatedPeripheral) {
		collection.updateOne(Filters.eq("name", name), new Document("$set",
				new Document("price", updatedPeripheral.getPrice()).append("brand", updatedPeripheral.getBrand())));
	}

	@Override
	public Peripheral findByName(String name) {
		Document doc = collection.find(Filters.eq("name", name)).first();
		return null;
	}

	@Override
	public void delete(String name) {
		collection.deleteOne(Filters.eq("name", name));
	}

	@Override
	public Peripheral documentToPeripheral(Document document) {
		String name = document.getString("name");
		double price = document.getDouble("price");
		String brand = document.getString("brand");
		String description = document.getString("description");

		return Peripheral.builder().name(name).price(price).brand(brand).description(description).build();
	}

	@Override
	public List<Peripheral> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
