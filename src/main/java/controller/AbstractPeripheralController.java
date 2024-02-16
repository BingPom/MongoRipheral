package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;

import db.MongoDriver;
import model.Peripheral;

public abstract class AbstractPeripheralController implements IPeripheralController {
	protected MongoCollection<Document> collection;

	public AbstractPeripheralController() {
		MongoDriver.getClient();
	}

	public Object insert(Peripheral peripheral) {
		Document document = new Document("name", peripheral.getName()).append("price", peripheral.getPrice())
				.append("brand", peripheral.getBrand()).append("description", peripheral.getDescription())
				.append("type", peripheral.getType()).append("attributes", peripheral.getAttributes());

		return collection.insertOne(document);
	}

	public Object update(String id, Peripheral updatedPeripheral) {
		Document updatedDocument = new Document("$set", new Document("name", updatedPeripheral.getName())
				.append("price", updatedPeripheral.getPrice()).append("brand", updatedPeripheral.getBrand())
				.append("description", updatedPeripheral.getDescription()).append("type", updatedPeripheral.getType())
				.append("attributes", updatedPeripheral.getAttributes()));

		return collection.updateOne(Filters.eq("_id", id), updatedDocument);
	}

	@Override
	public List<Peripheral> findByName(String name) {
		List<Peripheral> peripherals = new ArrayList<>();
		MongoIterable<String> collectionNames = MongoDriver.getDatabase().listCollectionNames();

		for (String collectionName : collectionNames) {
			collection = MongoDriver.getDatabase().getCollection(collectionName);

			collection.find(Filters.regex(name, Pattern.compile(name, Pattern.CASE_INSENSITIVE)))
					.forEach(document -> peripherals.add(documentToPeripheral(document)));
		}

		return peripherals;
	}

	@Override
	public Object delete(String name, String id) {
		Document filter = new Document("name", name).append("_id", id);

		return collection.deleteOne(Filters.and(filter));
	}

	@Override
	public HashMap<String, Peripheral> findAll() {
		HashMap<String, Peripheral> peripherals = new HashMap<String, Peripheral>();

		MongoIterable<String> collectionNames = MongoDriver.getDatabase().listCollectionNames();

		for (String collectionName : collectionNames) {
			collection = MongoDriver.getDatabase().getCollection(collectionName);
			collection.find()
					.forEach(document -> peripherals.put(document.getObjectId("_id").toString(), documentToPeripheral(document)));
		}

		return peripherals;
	}

	@Override
	public Peripheral documentToPeripheral(Document document) {
		String name = document.getString("name");
		Double price = document.getDouble("price");
		String brand = document.getString("brand");
		String description = document.getString("description");
		String type = document.getString("type");

		Document attributesDocument = (Document) document.get("attributes");
		HashMap<String, String> attributes = new HashMap<>();

		if (attributesDocument != null) {
			for (String key : attributesDocument.keySet()) {
				attributes.put(key, attributesDocument.getString(key));
			}
		}

		return Peripheral.builder().name(name).price(price).brand(brand).description(description).type(type)
				.attributes(attributes).build();
	}

	@Override
	public void closeConnection() {
		MongoDriver.getClient().close();
	}
}
