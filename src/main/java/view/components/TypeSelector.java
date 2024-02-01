package view.components;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class TypeSelector extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private String otherType;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
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
		
		JTextField textFieldType = new JTextField();
		textFieldType.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				setOtherType(textFieldType.getText());
			}
		});
		textFieldType.setBounds(155, 0, 145, 23);
		textFieldType.setColumns(10);
		
		JComboBox<Object> comboBoxType = new JComboBox<Object>();
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
		comboBoxType.setModel(new DefaultComboBoxModel<Object>(new String[] {"Test 1", "Test 2", "Otro"}));
		comboBoxType.setBounds(0, 0, 145, 23);
		add(comboBoxType);
		add(textFieldType);
	}

}
