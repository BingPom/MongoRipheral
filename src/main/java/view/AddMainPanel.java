package view;

import javax.swing.JPanel;

import enums.Window;

import java.awt.Dimension;

import view.components.AttributesEditor;
import view.components.PriceSelector;
import view.components.TypeSelector;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Dimension size = new Dimension(530, 370);
	/**
	 * Create the panel.
	 */
	public AddMainPanel(MainWindow parent) {
		setLayout(null);
		
		PriceSelector spinnerPrice = new PriceSelector(0d);
		spinnerPrice.setBounds(306, 36, 72, 30);
		add(spinnerPrice);
		
		JLabel lblHeadText = new JLabel("Introduzca los datos del producto a añadir: ");
		lblHeadText.setBounds(10, 11, 351, 14);
		add(lblHeadText);
		
		JButton btnBack = new JButton("Cancelar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.goToCard(Window.Main_Window);
			}
		});
		btnBack.setBounds(10, 296, 89, 23);
		add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(25, 36, 46, 14);
		add(lblNewLabel_1);
		
		AttributesEditor internalFrame = new AttributesEditor();
		internalFrame.setBounds(-115, 58, 638, 401);
		add(internalFrame);
		internalFrame.setVisible(true);
		
		
		

	}
}
