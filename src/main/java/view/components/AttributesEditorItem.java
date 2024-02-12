package view.components;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class AttributesEditorItem extends JPanel {

	private static final long serialVersionUID = 1L;
	private String attributeName = new String();
	private String attributeValue = new String();
	private JTextField textFieldAttributeName;
	private JTextField textFieldAttributeValue;
	
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	/**
	 * Create the panel.
	 */
	public AttributesEditorItem() {

		setSize(new Dimension(307, 23));
		
		textFieldAttributeName = new JTextField();
		textFieldAttributeName.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				setAttributeName(textFieldAttributeName.getText());
			}
		});
		textFieldAttributeName.setBounds(0, 0, 145, 23);
		textFieldAttributeName.setColumns(15);
		setLayout(null);
		add(textFieldAttributeName);
		
		JLabel lblLine = new JLabel("|");
		lblLine.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLine.setBounds(151, 0, 5, 23);
		add(lblLine);


		textFieldAttributeValue = new JTextField();
		textFieldAttributeValue.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				setAttributeValue(textFieldAttributeValue.getText());
			}
		});
		textFieldAttributeValue.setBounds(162, 0, 145, 23);
		textFieldAttributeValue.setColumns(15);
		setLayout(null);
		add(textFieldAttributeValue);

	}
	
	public void setEditable(boolean enabled) {
		textFieldAttributeName.setEditable(enabled);
		textFieldAttributeValue.setEditable(enabled);
	}

}
