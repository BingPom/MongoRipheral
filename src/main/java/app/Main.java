package app;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import db.MongoDriver;
import enums.AudioType;
import enums.Connectivity;
import enums.KBLayout;
import enums.KBSize;
import enums.KBSwitches;
import enums.MSensorType;
import model.Headset;
import model.Keyboard;
import model.Mouse;
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

		Peripheral mouse = Mouse.builder().name("Nombre del mouse").price(100.0).brand("Marca del mouse")
				.description("Descripción del mouse").connectivity(Connectivity.WIRED).sensorType(MSensorType.OPTICAL)
				.sensor("Nombre del sensor").build();
		System.out.println(mouse);

		Peripheral hs = Headset.builder().name("Nombre del casco").price(100.0).brand("Marca del casco")
				.description("Descripción del casco").connectivity(Connectivity.WIRELESS)
				.audio(AudioType.SUROOUND_SEVEN_ONE).build();
		System.out.println(hs);
	}

}
