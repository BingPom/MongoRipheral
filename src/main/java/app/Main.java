package app;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import db.MongoDriver;
import enums.KBLayout;
import enums.KBSize;
import enums.KBSwitches;
import model.Keyboard;
import model.Peripheral;

public class Main {

	public static void main(String[] args) {
		MongoClient client = MongoDriver.getClient();
		MongoDatabase database = MongoDriver.getDatabase();

		// client.getDatabase("MongoRipheral");

		Peripheral test = Peripheral.builder().name("Nombre del periférico").price(100.0).brand("Marca del periférico")
				.description("Descripción del periférico").build();
		System.out.println(test.toString());

		Peripheral kb = Keyboard.builder().name("Nombre del teclado").price(100.0).brand("Marca del teclado")
				.description("Descripción del teclado").layout(KBLayout.ISO).size(KBSize.TKL).switches(KBSwitches.RED)
				.build();
		System.out.println(kb);
	}

}
