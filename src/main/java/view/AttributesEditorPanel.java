package view;

import javax.swing.JPanel;

import enums.Window;
import model.Peripheral;
import utils.dbUtils;

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

import controller.PeripheralController;

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
	private JTextField textFieldDescription;
	private String peripheralId;
	private String initialType;
	private PeripheralController controller = new PeripheralController();
	public String getInitialType() {
		return initialType;
	}

	public void setInitialType(String initialType) {
		this.initialType = initialType;
	}


	public String getPeripheralId() {
		return peripheralId;
	}

	public void setPeripheralId(String peripheralId) {
		this.peripheralId = peripheralId;
	}

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
		this.setInitialType(peripheral.getType());
		this.peripheral = peripheral;
		textFieldName.setText(peripheral.getName() == null ? "" : this.getPeripheral().getName());
		typeSelector.updateType(peripheral.getType() == null ? "Teclado" : this.getPeripheral().getType());
		textFieldBrand.setText(peripheral.getBrand() == null ? "" : this.getPeripheral().getBrand());
		priceSelector.updatePrice(peripheral.getPrice() == null ? 0 : this.getPeripheral().getPrice());
		textFieldDescription.setText(peripheral.getDescription() == null ? "" : this.getPeripheral().getDescription());
		if (peripheral.getAttributes() != null) {
			attEditor.updateData(peripheral.getAttributes());
			if (mode.equalsIgnoreCase("view") || mode.equalsIgnoreCase("delete")) {
				attEditor.setEditable(false);
			}
		} else {
			attEditor.dropData();
			if (mode.equalsIgnoreCase("view") || mode.equalsIgnoreCase("delete")) {
				attEditor.setEditable(false);
			}
		}
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
		attEditor.setSize(400, 265);
		attEditor.setForeground(new Color(0, 0, 0));
		attEditor.setBorder(null);
		attEditor.setLocation(46, 222);
		attEditor.setVisible(true);
		add(attEditor);

//		In view mode there´s no button in the bottom-right corner
		if (!mode.equalsIgnoreCase("view")) {
			JButton btnAction = new JButton();
			setButtonText(btnAction);
			btnAction.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					doAction(nextWindow);
				}
			});
			btnAction.setBounds(424, 498, 89, 23);
			add(btnAction);
		}

		JLabel lblName = new JLabel("Nombre: ");
		lblName.setBounds(46, 54, 46, 14);
		add(lblName);

		textFieldName = new JTextField();
		textFieldName.setText(this.getPeripheral().getName());
		textFieldName.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				getPeripheral().setName(textFieldName.getText());
			}
		});
		textFieldName.setColumns(10);
		textFieldName.setBounds(102, 51, 148, 20);
		add(textFieldName);

		JLabel lblType = new JLabel("Tipo: ");
		lblType.setBounds(46, 88, 46, 14);
		add(lblType);

		typeSelector = new TypeSelector(false);
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
				getPeripheral().setBrand(textFieldBrand.getText());
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

		JLabel lblDescription = new JLabel("Descripción: ");
		lblDescription.setBounds(46, 192, 80, 14);
		add(lblDescription);

		textFieldDescription = new JTextField();
		textFieldDescription.setText(this.getPeripheral().getDescription());
		textFieldDescription.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				getPeripheral().setDescription(textFieldDescription.getText());
			}
		});
		textFieldDescription.setColumns(40);
		textFieldDescription.setBounds(112, 189, 334, 20);
		add(textFieldDescription);

		checkEditable();
	}

	private void setButtonText(JButton btnAction) {
		switch (this.getMode()) {
		case "create":
			btnAction.setText("Añadir");
			break;
		case "update":
			btnAction.setText("Guardar");
			break;
		case "delete":
			btnAction.setText("Eliminar");
			break;
		default:
			btnAction.setText("Error");
			break;
		}
	}

	private void doAction(Window nextWindow) {
//		Check fields are not empty
		if (isFieldsEmpty()) {
			JOptionPane.showMessageDialog(getParentFrame(), "Rellene todos los campos");
			return;
		}
		this.getPeripheral().setType(typeSelector.getSelectedType());
		this.getPeripheral().setPrice(priceSelector.getPrice());
		this.getPeripheral().setAttributes(attEditor.getAttributesHashMap());
		switch (this.getMode()) {
		case "create":
			if (controller.create(this.getPeripheral()) != null) {
				JOptionPane.showMessageDialog(getParentFrame(), "Periférico añadido correctamente");
				this.getParentFrame().goToCard(nextWindow);
			} else {
				JOptionPane.showMessageDialog(getParentFrame(), "Error, compruebe que los datos son correctos");
			}
			break;

		case "update":
			if (controller.update(this.getPeripheralId(), this.getPeripheral(), this.getInitialType()) != null) {
				JOptionPane.showMessageDialog(getParentFrame(), "Periférico actualizado correctamente");
				dbUtils.findAllAndUpdateTable(this.getParentFrame(), controller, nextWindow);
			} else {
				JOptionPane.showMessageDialog(getParentFrame(), "Error, compruebe que los datos son correctos");
			}
			break;

		case "delete":
			if (controller.delete(this.getPeripheral(), this.getPeripheralId()) != null) {
				JOptionPane.showMessageDialog(getParentFrame(), "Periférico eliminado correctamente");
				dbUtils.findAllAndUpdateTable(this.getParentFrame(), controller, nextWindow);
			} else {
				JOptionPane.showMessageDialog(getParentFrame(), "Error a la hora de eliminar el periférico");
			}
			break;
		default:
			break;
		}
	}

	private void checkEditable() {
		if (this.getMode().equalsIgnoreCase("view") || this.getMode().equalsIgnoreCase("delete")) {
			textFieldName.setEditable(false);
			textFieldBrand.setEditable(false);
			textFieldDescription.setEditable(false);
			typeSelector.setEditable(false);
			priceSelector.setEditable(false);
			attEditor.setEditable(false);
		}
	}

	private boolean isFieldsEmpty() {
		return textFieldName.getText().isBlank() || textFieldBrand.getText().isBlank()
				|| textFieldDescription.getText().isBlank() || priceSelector.getPrice() <= 0;
	}
}
