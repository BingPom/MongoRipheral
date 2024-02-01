package controller;

import db.MongoDriver;

public class HeadsetController extends AbstractPeripheralController {
	private static final String COLLECTION_NAME = "headsets";

	public HeadsetController() {
		super();
		this.collection = MongoDriver.getDatabase().getCollection(COLLECTION_NAME);
	}
}
