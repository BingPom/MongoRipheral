package controller;

import model.Peripheral;

public class MRController {
	private KeyboardController kbController;
	private MouseController mController;
	private HeadsetController hController;

	public MRController() {
		kbController = new KeyboardController();
		mController = new MouseController();
		hController = new HeadsetController();
	}

	public void create(Peripheral peripheral) {
		switch (peripheral.getType()) {
		case "Teclado":
			kbController.insert(null);
			break;

		case "Ratón":
			mController.insert(null);
			break;

		case "Cascos":
			hController.insert(null);
			break;

		}

	}

	public void read(String nombre) {

	}

	public void update(Peripheral peripheral) {

	}

	public void delete(String nombre) {

	}
}
