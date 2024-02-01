package view.components;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class AttributesEditor extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AttributesEditor() {
		setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(433, 0, 17, 300);
		add(scrollBar);

	}
}
