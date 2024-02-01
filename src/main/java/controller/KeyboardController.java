package controller;

import db.MongoDriver;

public class KeyboardController extends AbstractPeripheralController {
	private static final String COLLECTION_NAME = "keyboards";

	public KeyboardController() {
		super();
		this.collection = MongoDriver.getDatabase().getCollection(COLLECTION_NAME);
	}
}
