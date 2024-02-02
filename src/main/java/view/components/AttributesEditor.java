package view.components;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class AttributesEditor extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AttributesEditor() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 183, 351, 186);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		AttributesEditorScrollPanel test = new AttributesEditorScrollPanel();
		test.setLocation(146, 11);
		add(test);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(208, 23, 46, 14);
		add(lblNewLabel);

		
	}
}
