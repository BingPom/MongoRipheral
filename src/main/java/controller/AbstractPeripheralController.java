package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import db.MongoDriver;
import model.Peripheral;

public abstract class AbstractPeripheralController implements PeripheralController {
	protected MongoCollection<Document> collection;

	public AbstractPeripheralController() {
		MongoDriver.getClient();
	}

	public void insert(Peripheral peripheral) {
		Document document = new Document("name", peripheral.getName()).append("price", peripheral.getPrice())
				.append("brand", peripheral.getBrand()).append("description", peripheral.getDescription())
				.append("type", peripheral.getType()).append("attributes", peripheral.getAttributes());

		collection.insertOne(document);
	}

	public void update(String name, Peripheral updatedPeripheral) {
		collection.updateOne(Filters.eq("name", name), new Document("$set",
				new Document("price", updatedPeripheral.getPrice()).append("brand", updatedPeripheral.getBrand())));
	}

	@Override
	public Peripheral findByName(String name) {
		Document doc = collection.find(Filters.eq("name", name)).first();
		Set<String> keys = doc.keySet();
		return doc != null ? documentToPeripheral(doc) : null;

	}

	@Override
	public void delete(String name) {
		collection.deleteOne(Filters.eq("name", name));
	}

	@Override
	public List<Peripheral> findAll() {
		List<Peripheral> peripherals = new ArrayList<>();
		collection.find().forEach(document -> peripherals.add(documentToPeripheral(document)));

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
