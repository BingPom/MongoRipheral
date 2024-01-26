package view;

import javax.swing.JFrame;

import enums.Windows;

import java.awt.CardLayout;
import java.awt.Container;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	CardLayout card;
	Container container;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainWindow frame = new MainWindow();
	    frame.setSize(435, 234);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);
		container = getContentPane();
		card = new CardLayout();
		container.setLayout(card);
		
		MainWindowPanel panel1 = new MainWindowPanel(this);
		SearchMainPanel panel2 = new SearchMainPanel();
		
		container.add(Windows.Main_Window.toString(), panel1);
		container.add(Windows.Search_Main_Window.toString(), panel2);
		
	}
	
	public void goToCard(Windows window) {
		card.show(container, window.toString());
	}
}
