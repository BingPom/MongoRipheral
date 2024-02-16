package controller;

import java.util.HashMap;
import java.util.List;

import org.bson.Document;

import model.Peripheral;

public interface IPeripheralController {

	/**
	 * Insert a new peripheral into the database
	 * 
	 * @param peripheral The new peripheral to insert
	 * @return 
	 */
	public Object insert(Peripheral peripheral);

	/**
	 * Get all the peripheral stored in the database
	 * 
	 * @return A list containing all the peripherals
	 */
	public HashMap<String, Peripheral> findAll();

	/**
	 * Get all the peripheral that matches the given String
	 * 
	 * @param name The String to match
	 * @return A list of the peripherals that matches the String
	 */
	public List<Peripheral> findByName(String name);

	/**
	 * Update the given peripheral in the database
	 * 
	 * @param name              Name of the peripheral to update
	 * @param updatedPeripheral The updated data of the peripheral
	 * @return 
	 */
	public Object update(String name, Peripheral updatedPeripheral);

	/**
	 * Delete fron the database the given peripheral
	 * 
	 * @param name The name of the peripheral to be deleted
	 * @param id   The id of the peripheral to be deleted
	 * @return 
	 */
	public Object delete(String id);

	/**
	 * A help method to translate a Document from database into a Peripheral object
	 * 
	 * @param document The Document to translate
	 * @return The translated peripheral
	 */
	Peripheral documentToPeripheral(Document document);

	/**
	 * Close the connection to the database
	 */
	public void closeConnection();

}
