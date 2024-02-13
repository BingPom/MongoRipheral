package view;

import javax.swing.JPanel;

import enums.Window;
import model.Peripheral;

import java.awt.Dimension;

import view.components.AttributesEditor;
import view.components.PriceSelector;
import view.components.TypeSelector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AttributesEditorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public Dimension size = new Dimension(530, 370);
	private JTextField textFieldName;
	private JTextField textFieldBrand;
	private TypeSelector typeSelector;
	private PriceSelector priceSelector;
	private AttributesEditor attEditor;
	private Peripheral peripheral = new Peripheral();
	private String mode;
	private MainWindow parentFrame;

	public MainWindow getParentFrame() {
		return parentFrame;
	}

	public void setParentFrame(MainWindow parentFrame) {
		this.parentFrame = parentFrame;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Peripheral getPeripheral() {
		return peripheral;
	}

	public void setPeripheral(Peripheral peripheral) {
		this.peripheral = peripheral;
		textFieldName.setText(this.getPeripheral().getName());
		typeSelector.setType(this.getPeripheral().getType());
		textFieldBrand.setText(this.getPeripheral().getName());
		priceSelector.setPrice(this.getPeripheral().getPrice());
	}

	/**
	 * Create the panel.
	 */
	public AttributesEditorPanel(MainWindow parent, String mode, Window previousWindow, Window nextWindow) {
		setParentFrame(parent);
		this.setMode(mode);
		
		setLayout(null);

		JLabel lblHeadText = new JLabel("Introduzca los datos del producto a añadir: ");
		lblHeadText.setBounds(10, 11, 351, 14);
		add(lblHeadText);

		JButton btnBack = new JButton("Cancelar");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.goToCard(previousWindow);
			}
		});
		btnBack.setBounds(10, 498, 89, 23);
		add(btnBack);

		attEditor = new AttributesEditor();
		attEditor.setForeground(new Color(0, 0, 0));
		attEditor.setBorder(null);
		attEditor.setLocation(46, 190);
		add(attEditor);

		JButton btnCrear = new JButton();
		setButtonText(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(nextWindow);
			}
		});
		btnCrear.setBounds(424, 498, 89, 23);
		add(btnCrear);

		JLabel lblName = new JLabel("Nombre: ");
		lblName.setBounds(46, 54, 46, 14);
		add(lblName);

		textFieldName = new JTextField();
		textFieldName.setText(this.getPeripheral().getName());
		textFieldName.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				getPeripheral().setName(textFieldName.getText());
//				textFieldName.setText(getPeripheral().getName());
			}
		});
		textFieldName.setColumns(10);
		textFieldName.setBounds(102, 51, 148, 20);
		add(textFieldName);

		JLabel lblType = new JLabel("Tipo: ");
		lblType.setBounds(46, 88, 46, 14);
		add(lblType);

		typeSelector = new TypeSelector();
		typeSelector.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				getPeripheral().setType(typeSelector.getType());
			}
		});
		typeSelector.setBounds(102, 84, 300, 23);
		add(typeSelector);
		
		JLabel lblBrand = new JLabel("Marca: ");
		lblBrand.setBounds(46, 122, 46, 14);
		add(lblBrand);

		textFieldBrand = new JTextField();
		textFieldBrand.setText(this.getPeripheral().getName());
		textFieldBrand.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				textFieldName.setText(getPeripheral().getName());
			}
		});
		textFieldBrand.setColumns(10);
		textFieldBrand.setBounds(102, 119, 148, 20);
		add(textFieldBrand);

		priceSelector = new PriceSelector(0d);
		priceSelector.setBounds(102, 148, 59, 30);
		add(priceSelector);

		JLabel lblPrice = new JLabel("Precio: ");
		lblPrice.setBounds(46, 156, 46, 14);
		add(lblPrice);
		attEditor.setVisible(true);

		checkEditable();
	}

	private void setButtonText(JButton btnCrear) {
		switch (this.getMode()) {
		case "create":
			btnCrear.setText("Añadir");
			break;
		case "edit":
			btnCrear.setText("Guardar");
			break;
		default:
			btnCrear.setText("Error");
			break;
		}
	}

	private void doAction(Window nextWindow) {
		switch (this.getMode()) {
		case "edit":

			break;

		case "delete":

			break;
			
		case "view":
			
			break;
		default:
			break;
		}

		JOptionPane.showMessageDialog(getParentFrame(), "adsa");
		this.getParentFrame().goToCard(nextWindow);
	}
	
	private void checkEditable() {
		if (this.getMode().equalsIgnoreCase("view") || this.getMode().equalsIgnoreCase("delete")) {
			textFieldName.setEditable(false);
			textFieldBrand.setEditable(false);
			typeSelector.setEditable(false);
			priceSelector.setEditable(false);
			attEditor.setEditable(false);
		}
	}
}
