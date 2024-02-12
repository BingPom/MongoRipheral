package controller;

import java.util.List;

import db.MongoDriver;
import model.Peripheral;

public class PeripheralController extends AbstractPeripheralController {

	public PeripheralController() {
	}

	public void create(Peripheral peripheral) {
		getPeripheralCollection(peripheral);

		super.insert(peripheral);
	}

	public List<Peripheral> findByName(String nombre) {
		return super.findByName(nombre);
	}

	public void update(String id, Peripheral peripheral) {
		getPeripheralCollection(peripheral);

		super.update(id, peripheral);

	}

	public void delete(Peripheral peripheral, String id) {
		getPeripheralCollection(peripheral);

		super.delete(peripheral.getName(), id);
	}

	private void getPeripheralCollection(Peripheral peripheral) {
		collection = MongoDriver.getDatabase().getCollection(peripheral.getType());
	}
}
