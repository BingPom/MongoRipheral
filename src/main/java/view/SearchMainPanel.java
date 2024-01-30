package view;

import javax.swing.JPanel;

import view.components.PriceRangeSelector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldType;
	private MainWindow parent;

	/**
	 * Create the panel.
	 */
	public SearchMainPanel(MainWindow frame) {
		parent = frame;
		setLayout(null);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.setBounds(316, 158, 89, 23);
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
		
		JLabel lblType = new JLabel("Tipo: ");
		lblType.setBounds(32, 95, 46, 14);
		add(lblType);
		
		textFieldType = new JTextField();
		textFieldType.setBounds(228, 92, 145, 20);
		add(textFieldType);
		textFieldType.setColumns(10);
		
		JComboBox<Object> comboBoxType = new JComboBox<Object>();
		comboBoxType.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (comboBoxType.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
					textFieldType.setVisible(true);
				} else {
					textFieldType.setText("");
					textFieldType.setVisible(false);
				}
			}
		});
		comboBoxType.setModel(new DefaultComboBoxModel<Object>(new String[] {"Test 1", "Test 2", "Otro"}));
		comboBoxType.setBounds(73, 91, 145, 22);
		add(comboBoxType);
		
		JButton btnBack = new JButton("Cancelar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.goToPreviousCard();
			}
		});
		btnBack.setBounds(22, 158, 89, 23);
		add(btnBack);
	}
}
