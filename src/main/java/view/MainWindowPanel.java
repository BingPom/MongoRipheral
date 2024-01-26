package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.Windows;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MainWindowPanel(MainWindow frame) {

		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.setBounds(218, 133, 79, 23);
		
		JButton btnDelete = new JButton("Borrar");
		btnDelete.setBounds(317, 133, 79, 23);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.goToCard(Windows.Search_Main_Window);
			}
		});
		btnSearch.setBounds(20, 133, 79, 23);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.setBounds(119, 133, 79, 23);
		
		JLabel lblSelectOption = new JLabel("Seleccione una opción:");
		lblSelectOption.setBounds(30, 101, 168, 14);
		this.setLayout(null);
		
		JLabel lblWelcome = new JLabel("BIENVENIDO A MONGORIPHERAL");
		lblWelcome.setBounds(30, 37, 359, 29);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		this.add(lblWelcome);
		this.add(lblSelectOption);
		this.add(btnAdd);
		this.add(btnUpdate);
		this.add(btnSearch);
		this.add(btnDelete);
		
	}

}
