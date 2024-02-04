package app;


import java.util.HashMap;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.KeyboardController;
import model.Peripheral;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {/*
		// Create a KeyboardController
		KeyboardController keyboardController = new KeyboardController();

		// Create a new peripheral
		Peripheral keyboard = Peripheral.builder().name("Mechanical Keyboard").price(99.99).brand("Logitech")
				.description("High-quality mechanical keyboard").type("Keyboard").attributes(new HashMap<>()).build();
		// Create and add a new keyboard
		keyboardController.insert(keyboard);

		// Display all peripherals
		List<Peripheral> peripheralsBeforeUpdate = keyboardController.findAll();
		peripheralsBeforeUpdate.forEach(System.out::println);
		// PeripheralView peripheralView = new PeripheralView();
		// peripheralView.displayPeripherals(peripheralsBeforeUpdate);

		// Update the peripheral's information
		Peripheral updatedKeyboard = Peripheral.builder().name("Mechanical Keyboard").price(129.99).brand("Logitech")
				.description("Premium mechanical keyboard with RGB lighting").type("Keyboard")
				.attributes(new HashMap<>()).build();

		keyboardController.update("Mechanical Keyboard", updatedKeyboard);

		// Display all peripherals after the update
		List<Peripheral> peripheralsAfterUpdate = keyboardController.findAll();
		peripheralsAfterUpdate.forEach(System.out::println);

		// Find a peripheral by name
		Peripheral foundKeyboard = keyboardController.findByName("Mechanical Keyboard");
		System.out.println("Found Peripheral: " + foundKeyboard);

		// Delete the peripheral
		// keyboardController.delete("Mechanical Keyboard");

		// Display all peripherals after the delete
		List<Peripheral> peripheralsAfterDelete = keyboardController.findAll();
		peripheralsAfterDelete.forEach(System.out::println);
		// peripheralView.displayPeripherals(peripheralsAfterDelete);

		keyboardController.closeConnection();*/
//		Start GUI
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new MainWindow();
	}
}
