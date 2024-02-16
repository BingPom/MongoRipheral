package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PeripheralController;
import enums.Window;
import model.Peripheral;
import utils.dbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindowPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow parent;
	private PeripheralController controller = new PeripheralController();

	/**
	 * Create the panel.
	 */
	public MainWindowPanel(MainWindow frame) {
		parent = frame;
		setLayout(null);

		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiltersPanel a = (FiltersPanel) parent.getClassByWindow(Window.Search_Main_Window);
				a.resetFields();
				parent.goToCard(Window.Search_Main_Window);
			}
		});
		btnSearch.setBounds(23, 133, 79, 23);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttributesEditorPanel a = (AttributesEditorPanel) parent.getClassByWindow(Window.Add_Main_Window);
				a.setPeripheral(new Peripheral());
				parent.goToCard(Window.Add_Main_Window);
			}
		});
		btnAdd.setBounds(124, 133, 79, 23);
		
		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUtils.findAllAndUpdateTable(frame, controller, Window.Update_Main_Window);
			}
		});
		btnUpdate.setBounds(227, 133, 79, 23);
		
		JButton btnDelete = new JButton("Borrar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUtils.findAllAndUpdateTable(frame, controller, Window.Delete_Main_Window);
			}
		});
		btnDelete.setBounds(329, 133, 79, 23);
		
		JLabel lblSelectOption = new JLabel("Seleccione una opción:");
		lblSelectOption.setBounds(30, 101, 168, 14);
		this.setLayout(null);
		
		JLabel lblWelcome = new JLabel("BIENVENIDO A MONGORIPHERAL");
		lblWelcome.setBounds(30, 37, 378, 29);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		this.add(lblWelcome);
		this.add(lblSelectOption);
		this.add(btnAdd);
		this.add(btnUpdate);
		this.add(btnSearch);
		this.add(btnDelete);
		
	}

}
