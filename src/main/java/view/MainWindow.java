package view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import enums.Window;
import enums.Window_Dimension;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	CardLayout card;
	Container container;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(new ImageIcon("./src/main/res/Icon_16x16.png").getImage());
		
		setSize(Window_Dimension.Main_Window.size);
		centerWindow();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		container = getContentPane();
		card = new CardLayout();
		container.setLayout(card);

		MainWindowPanel panel1 = new MainWindowPanel(this);
		SearchMainPanel panel2 = new SearchMainPanel(this);
		AddMainPanel panel3 = new AddMainPanel(this);

		container.add(Window.Main_Window.name.toString(), panel1);
		container.add(Window.Search_Main_Window.name.toString(), panel2);
		container.add(Window.Add_Main_Window.name.toString(), panel3);

	}

	public void goToCard(Window window) {
		card.show(container, window.name.toString());
		setSize(window.size);
		centerWindow();
	}
	
	private void centerWindow() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(d.width / 2 - this.getSize().width / 2, d.height / 2 - this.getSize().height / 2);
	}
}
