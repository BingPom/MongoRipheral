package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SearchMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public SearchMainPanel() {
		setLayout(null);
		
		JButton btnSearch = new JButton("New button");
		btnSearch.setBounds(351, 266, 89, 23);
		add(btnSearch);
		
		JLabel lblHeader = new JLabel("Introduzca sus preferencias de búsqueda: ");
		lblHeader.setBounds(22, 25, 243, 14);
		add(lblHeader);

	}
}
