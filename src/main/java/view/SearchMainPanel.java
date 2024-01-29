package view;

import javax.swing.JPanel;

import view.components.PriceRangeSelector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class SearchMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldType;

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
		
		PriceRangeSelector prs = new PriceRangeSelector(0d, 100d, 500d);
		prs.setBounds(74, 50, 220, 30);
		add(prs);
		
		JLabel lblPrice = new JLabel("Precio: ");
		lblPrice.setBounds(32, 58, 46, 14);
		add(lblPrice);
		
		JLabel lblType = new JLabel("Type: ");
		lblType.setBounds(32, 118, 46, 14);
		add(lblType);
		
		JComboBox comboBoxType = new JComboBox();
		comboBoxType.setModel(new DefaultComboBoxModel(new String[] {"Test 1", "Test 2", "Otro"}));
		comboBoxType.setBounds(74, 114, 145, 22);
		add(comboBoxType);
		
		textFieldType = new JTextField();
		textFieldType.setVisible(false);
		textFieldType.setBounds(229, 115, 145, 20);
		add(textFieldType);
		textFieldType.setColumns(10);

	}
}
