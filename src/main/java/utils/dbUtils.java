package utils;

import controller.PeripheralController;
import enums.Window;
import view.MainWindow;
import view.ResultsTablePanel;

public class dbUtils {

	public static void findAllAndUpdateTable(MainWindow parent, PeripheralController controller, Window nextPage) {
		ResultsTablePanel n = (ResultsTablePanel) parent.getClassByWindow(Window.Delete_Main_Window);
		n.updateTable(controller.findAll());
		parent.goToCard(nextPage);
	}
	
}
