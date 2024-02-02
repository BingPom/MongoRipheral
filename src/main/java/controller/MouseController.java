package controller;

import db.MongoDriver;

public class MouseController extends AbstractPeripheralController {
	private static final String COLLECTION_NAME = "keyboards";

	public MouseController() {
		super();
		this.collection = MongoDriver.getDatabase().getCollection(COLLECTION_NAME);
	}
}
