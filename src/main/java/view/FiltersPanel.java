package view;

import javax.swing.JPanel;

import enums.Window;
import view.components.PriceRangeSelector;
import view.components.TypeSelector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import controller.PeripheralController;

public class FiltersPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow parent;
	private JTextField textFieldName;
	private JTextField textFieldBrand;
	private PeripheralController controller = new PeripheralController();

	/**
	 * Create the panel.
	 */
	public FiltersPanel(MainWindow frame, Window previousPage, Window nextPage) {
		parent = frame;
		setLayout(null);
		
		JLabel lblHeader = new JLabel("Introduzca sus preferencias de búsqueda: ");
		lblHeader.setBounds(22, 21, 243, 14);
		add(lblHeader);
		
		PriceRangeSelector prs = new PriceRangeSelector(0d, 100d, 500d);
		prs.setBounds(88, 147, 220, 30);
		add(prs);
		
		JLabel lblPrice = new JLabel("Precio: ");
		lblPrice.setBounds(32, 155, 46, 14);
		add(lblPrice);
		
		JLabel lblType = new JLabel("Tipo: ");
		lblType.setBounds(32, 85, 46, 14);
		add(lblType);
		
		JButton btnBack = new JButton("Cancelar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.goToCard(previousPage);
			}
		});
		
		btnBack.setBounds(10, 206, 89, 23);
		add(btnBack);
		
		TypeSelector typeSelector = new TypeSelector();
		typeSelector.setBounds(88, 81, 300, 23);
		add(typeSelector);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (typeSelector.getSelectedType().isBlank()) {
					JOptionPane.showMessageDialog(parent, "El tipo no puede estar vacío, escríbalo o seleccione otra opción.");
				} else {					
					parent.goToCard(nextPage);
				}
			}
		});
		btnSearch.setBounds(336, 206, 89, 23);
		add(btnSearch);
		
		JLabel lblName = new JLabel("Nombre: ");
		lblName.setBounds(32, 50, 46, 14);
		add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(88, 47, 148, 20);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblBrand = new JLabel("Marca: ");
		lblBrand.setBounds(32, 120, 46, 14);
		add(lblBrand);
		
		textFieldBrand = new JTextField();
		textFieldBrand.setBounds(88, 117, 148, 20);
		add(textFieldBrand);
		textFieldBrand.setColumns(10);
	}
}
