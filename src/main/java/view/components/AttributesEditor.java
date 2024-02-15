package view.components;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.BorderLayout;

public class AttributesEditor extends JPanel {

	private static final long serialVersionUID = 1L;
	private AttributesEditorScrollPanel attributesScrollPanel;

	/**
	 * Create the panel.
	 */
	public AttributesEditor() {
		setSize(400, 279);
		
		attributesScrollPanel = new AttributesEditorScrollPanel() {
			private static final long serialVersionUID = 1L;
			private Dimension size;
			
			@Override
			public void setPreferredSize(Dimension preferredSize) {
				this.size = preferredSize;
			}
			
			@Override
			public Dimension getPreferredSize() {
				setPreferredSize(new Dimension(377, attributesScrollPanel.getComponentSize()));
				revalidate();
				return this.size;
			}
		};
		attributesScrollPanel.setPreferredSize(new Dimension(377, 279));
		attributesScrollPanel.revalidate();
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(attributesScrollPanel);
		add(scrollPane);
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 20));
		scrollPane.setColumnHeaderView(panel);
		
		JLabel lblProperties = new JLabel("                  Propiedad");
		
		JLabel lblNewLabel = new JLabel("|");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel lblValue = new JLabel("Valor                                          ");
		
		scrollPane.setColumnHeaderView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(lblProperties, BorderLayout.WEST);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		panel.add(lblValue, BorderLayout.EAST);
	}
	
	public void setEditable(boolean enabled) {
		attributesScrollPanel.setEditable(enabled);
	}
	
	public void updateData(HashMap<String, String> data) {
		attributesScrollPanel.updateAttributes(data);
	}
	
	public void dropData() {
		attributesScrollPanel.dropData();
	}
}
