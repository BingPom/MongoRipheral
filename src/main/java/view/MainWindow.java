package view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import enums.Window;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	CardLayout card;
	Container container;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(new ImageIcon("./src/main/res/Icon_16x16.png").getImage());
		
		setSize(Window.Main_Window.size);
		centerWindow();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		container = getContentPane();
		card = new CardLayout();
		container.setLayout(card);

		MainWindowPanel mainWindow = new MainWindowPanel(this);
		SearchMainPanel searchMainWindow = new SearchMainPanel(this);
		ResultsTablePanel searchResultsWindow = new ResultsTablePanel(this, "search");
		ElementEditorPanel addMainWindow = new ElementEditorPanel(this, "create");

		container.add(Window.Main_Window.name.toString(), mainWindow);
		container.add(Window.Search_Main_Window.name.toString(), searchMainWindow);
		container.add(Window.Result_Table_Window.toString(), searchResultsWindow);
		container.add(Window.Editor_Main_Window.name.toString(), addMainWindow);

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
