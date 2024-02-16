package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.conversions.Bson;

import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;

import db.MongoDriver;
import model.Peripheral;

public class PeripheralController extends AbstractPeripheralController {

	public PeripheralController() {
		super();
	}

	public Object create(Peripheral peripheral) {
		getPeripheralCollection(peripheral);

		return super.insert(peripheral);
	}

	public List<Peripheral> findByName(String nombre) {
		return super.findByName(nombre);
	}

	/**
	 * Get the peripherals that match the filter given by parameter
	 * 
	 * @param peripheral A placeholder containing the filters
	 * @return A list with all the peripherals that match the filter
	 */
	public List<Peripheral> filteredSearch(Peripheral peripheral, double minPrice, double maxPrice) {
		List<Peripheral> peripherals = new ArrayList<>();

		if (peripheral.getType() == null && peripheral.getBrand() == null) {
			return findByName(peripheral.getName());
		} else {

			if (peripheral.getBrand() == null) {
				findByType(peripheral, minPrice, maxPrice, peripherals);

			} else {
				MongoIterable<String> collectionNames = MongoDriver.getDatabase().listCollectionNames();

				for (String collectionName : collectionNames) {
					collection = MongoDriver.getDatabase().getCollection(collectionName);

					if (peripheral.getType() == null) {
						findByBrand(peripheral, minPrice, maxPrice, peripherals);
					} else {

						findByFilteredParameters(peripheral, minPrice, maxPrice, peripherals);
					}
				}
			}

		}

		return peripherals;
	}

	private void findByFilteredParameters(Peripheral peripheral, double minPrice, double maxPrice,
			List<Peripheral> peripherals) {
		Bson filter = Filters.and(
				Filters.regex("name", Pattern.compile(peripheral.getName(), Pattern.CASE_INSENSITIVE)),
				Filters.eq("type", peripheral.getType()),
				Filters.regex("brand", Pattern.compile(peripheral.getBrand(), Pattern.CASE_INSENSITIVE)),
				Filters.and(Filters.gte("price", minPrice), Filters.lte("price", maxPrice)));

		collection.find(filter).forEach(document -> peripherals.add(documentToPeripheral(document)));
	}

	private void findByBrand(Peripheral peripheral, double minPrice, double maxPrice, List<Peripheral> peripherals) {
		Bson filter = Filters.and(
				Filters.regex("name", Pattern.compile(peripheral.getName(), Pattern.CASE_INSENSITIVE)),
				Filters.regex("brand", Pattern.compile(peripheral.getBrand(), Pattern.CASE_INSENSITIVE)),
				Filters.and(Filters.gte("price", minPrice), Filters.lte("price", maxPrice)));

		collection.find(filter).forEach(document -> peripherals.add(documentToPeripheral(document)));
	}

	private void findByType(Peripheral peripheral, double minPrice, double maxPrice, List<Peripheral> peripherals) {
		Bson filter = Filters.and(
				Filters.regex("name", Pattern.compile(peripheral.getName(), Pattern.CASE_INSENSITIVE)),
				Filters.eq("type", peripheral.getType()),
				Filters.and(Filters.gte("price", minPrice), Filters.lte("price", maxPrice)));

		collection = MongoDriver.getDatabase().getCollection(peripheral.getType());
		collection.find(filter).forEach(document -> peripherals.add(documentToPeripheral(document)));
	}

	public Object update(String id, Peripheral peripheral) {
		getPeripheralCollection(peripheral);

		return super.update(id, peripheral);

	}

	public Object delete(Peripheral peripheral, String id) {
		getPeripheralCollection(peripheral);

		return super.delete(peripheral.getName(), id);
	}

	private void getPeripheralCollection(Peripheral peripheral) {
		collection = MongoDriver.getDatabase().getCollection(peripheral.getType());
	}
}
