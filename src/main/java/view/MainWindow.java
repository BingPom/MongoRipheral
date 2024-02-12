package view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
       
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
		
		FiltersPanel searchMainWindow = new FiltersPanel(this, Window.Main_Window, Window.Search_Result_Table);
		ResultsTablePanel searchResultsTable = new ResultsTablePanel(this, "search");
		AttributesEditorPanel searchAttributesViewer = new AttributesEditorPanel(this, "view");
		
		AttributesEditorPanel addMainPage = new AttributesEditorPanel(this, "create");
		
		ResultsTablePanel updateMainPage = new ResultsTablePanel(this, "update");
		AttributesEditorPanel updateAttributesEditor = new AttributesEditorPanel(this, "update");
		
		ResultsTablePanel deleteMainPage = new ResultsTablePanel(this, "delete");
		AttributesEditorPanel deleteAttributesEditor = new AttributesEditorPanel(this, "delete");

		container.add(Window.Main_Window.name.toString(), mainWindow);
		container.add(Window.Search_Main_Window.name.toString(), searchMainWindow);
		container.add(Window.Result_Table_Window.toString(), searchResultsWindow);
		container.add(Window.Add_Main_Window.name.toString(), addMainWindow);

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
