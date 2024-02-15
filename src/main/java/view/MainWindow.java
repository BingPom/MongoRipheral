package view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import enums.Window;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private CardLayout card;
	private Container container;
	private HashMap<String, Object> windowsClasses = new HashMap<String, Object>();

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
		ResultsTablePanel searchResultsTable = new ResultsTablePanel(this, "search", Window.Search_Main_Window,
				Window.Search_Attributes_Viewer);
		AttributesEditorPanel searchAttributesViewer = new AttributesEditorPanel(this, "view",
				Window.Search_Result_Table, Window.Search_Result_Table);

		AttributesEditorPanel addMainPage = new AttributesEditorPanel(this, "create", Window.Main_Window,
				Window.Main_Window);

		ResultsTablePanel updateMainPage = new ResultsTablePanel(this, "update", Window.Main_Window,
				Window.Update_Attributes_Editor);
		AttributesEditorPanel updateAttributesEditor = new AttributesEditorPanel(this, "update",
				Window.Update_Main_Window, Window.Update_Main_Window);

		ResultsTablePanel deleteMainPage = new ResultsTablePanel(this, "delete", Window.Main_Window,
				Window.Delete_Attributes_Editor);
		AttributesEditorPanel deleteAttributesEditor = new AttributesEditorPanel(this, "delete",
				Window.Delete_Main_Window, Window.Delete_Main_Window);

		container.add(Window.Main_Window.name.toString(), mainWindow);

		container.add(Window.Search_Main_Window.name.toString(), searchMainWindow);
		container.add(Window.Search_Result_Table.name.toString(), searchResultsTable);
		container.add(Window.Search_Attributes_Viewer.name.toString(), searchAttributesViewer);

		container.add(Window.Add_Main_Window.name.toString(), addMainPage);

		container.add(Window.Update_Main_Window.name.toString(), updateMainPage);
		container.add(Window.Update_Attributes_Editor.name.toString(), updateAttributesEditor);

		container.add(Window.Delete_Main_Window.name.toString(), deleteMainPage);
		container.add(Window.Delete_Attributes_Editor.name.toString(), deleteAttributesEditor);

		windowsClasses.put(Window.Main_Window.name.toString(), mainWindow);

		windowsClasses.put(Window.Search_Main_Window.name.toString(), searchMainWindow);
		windowsClasses.put(Window.Search_Result_Table.name.toString(), searchResultsTable);
		windowsClasses.put(Window.Search_Attributes_Viewer.name.toString(), searchAttributesViewer);

		windowsClasses.put(Window.Add_Main_Window.name.toString(), addMainPage);

		windowsClasses.put(Window.Update_Main_Window.name.toString(), updateMainPage);
		windowsClasses.put(Window.Update_Attributes_Editor.name.toString(), updateAttributesEditor);

		windowsClasses.put(Window.Delete_Main_Window.name.toString(), deleteMainPage);
		windowsClasses.put(Window.Delete_Attributes_Editor.name.toString(), deleteAttributesEditor);
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

	public Object getClassByWindow(Window window) {
		return windowsClasses.get(window.name);
	}
}
