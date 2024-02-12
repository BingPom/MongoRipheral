package view.components;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.CaretListener;

import enums.PeripheralTypes;

import javax.swing.event.CaretEvent;

public class TypeSelector extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private String otherType = new String();
	private JComboBox<String> comboBoxType;
	private JTextField textFieldType;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		
		comboBoxType.setSelectedItem(type);
		this.type = type;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.setType("Otro");
		this.otherType = otherType;
	}
	public String getSelectedType() {
		if(this.getType().equalsIgnoreCase("Otro")) {
			return this.getOtherType();
		}
		return this.getType();
	}

	/**
	 * Create the panel.
	 */
	public TypeSelector() {
		setSize(new Dimension(300, 23));
		
		textFieldType = new JTextField();
		textFieldType.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				setOtherType(textFieldType.getText());
			}
		});
		textFieldType.setBounds(155, 0, 145, 23);
		textFieldType.setColumns(10);
		
		comboBoxType = new JComboBox<String>();
		comboBoxType.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				setType(comboBoxType.getSelectedItem().toString());
				if (comboBoxType.getSelectedItem().toString().equalsIgnoreCase("Otro")) {
					textFieldType.setVisible(true);
				} else {
					textFieldType.setText("");
					textFieldType.setVisible(false);
				}
			}
		});
		setLayout(null);
		comboBoxType.setModel(new DefaultComboBoxModel<String>(getTypes()));
		comboBoxType.setSelectedIndex(comboBoxType.getItemCount() - 1);
		comboBoxType.setBounds(0, 0, 145, 23);
		add(comboBoxType);
		add(textFieldType);
	}
	
	private String[] getTypes() {
		ArrayList<String> types = new ArrayList<String>();
		for (PeripheralTypes type : PeripheralTypes.values()) {
			types.add(type.toString());
		}
		types.add("Otro");
		types.add("Todos");
		return types.toArray(String[]::new);
	}
	
	public void setEditable(boolean editable) {
		comboBoxType.setEnabled(editable);
		textFieldType.setEditable(editable);
	}

}
