package controller;

import db.MongoDriver;
import model.Peripheral;

public class MRController extends AbstractPeripheralController {

	public MRController() {
	}

	public void create(Peripheral peripheral) {
		getPeripheralCollection(peripheral);

		super.insert(peripheral);
	}

	public void read(String nombre) {

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
		switch (peripheral.getType()) {
		case "Teclado":
			collection = MongoDriver.getDatabase().getCollection("keyboard");
			break;

		case "Ratón":
			collection = MongoDriver.getDatabase().getCollection("mouse");
			break;

		case "Cascos":
			collection = MongoDriver.getDatabase().getCollection("headset");
			break;

		}
	}
}
