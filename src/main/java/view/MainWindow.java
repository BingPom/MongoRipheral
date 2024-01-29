package view;

import enums.Windows;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	CardLayout card;
	Container container;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(435, 234);
		setLocation(d.width / 2 - this.getSize().width / 2, d.height / 2 - this.getSize().height / 2);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
