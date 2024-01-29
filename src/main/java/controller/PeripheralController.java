package controller;

import java.util.List;

import org.bson.Document;

import model.Peripheral;

public interface PeripheralController {

	public void insert(Peripheral peripheral);

	public List<Peripheral> findAll();

	public Peripheral findByName(String name);

	public void update(String name, Peripheral updatedPeripheral);

	public void delete(String name);

	Peripheral documentToPeripheral(Document document);

}
