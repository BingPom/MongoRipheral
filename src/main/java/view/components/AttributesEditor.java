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
import javax.swing.ScrollPaneConstants;
import java.awt.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class AttributesEditor extends JPanel {

	private static final long serialVersionUID = 1L;
	private AttributesEditorScrollPanel aetsp;

	/**
	 * Create the panel.
	 */
	public AttributesEditor() {
		setSize(400, 279);
		
		aetsp = new AttributesEditorScrollPanel() {
			private Dimension size;
			
			@Override
			public void setPreferredSize(Dimension preferredSize) {
				this.size = preferredSize;
			}
			
			@Override
			public Dimension getPreferredSize() {
				// TODO Auto-generated method stub
				setPreferredSize(new Dimension(377, aetsp.getComponentSize()));
				revalidate();
				return this.size;
			}
		};
		aetsp.setPreferredSize(new Dimension(377, 279));
		aetsp.revalidate();
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(aetsp);
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
}
