package app;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Peripheral;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		Peripheral test = Peripheral.builder().name("Nombre del periférico").price(100.0).brand("Marca del periférico")
				.description("Descripción del periférico").build();
		System.out.println(test.toString());

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
