package view.components;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class AttributesEditorScrollPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int FIRST_ITEM_SPACE = 11;
	private static final int SPACE_BETWEEN_ITEMS = 34;

	private ArrayList<AttributesEditorItem> items = new ArrayList<AttributesEditorItem>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private JButton btnAdd;

	/**
	 * Create the panel.
	 */
	public AttributesEditorScrollPanel() {
		setSize(new Dimension(377, 217));

		setLayout(null);

		items.add(new AttributesEditorItem());
		items.get(0).setLocation(10, FIRST_ITEM_SPACE);
		add(items.get(0));

		buttons.add(new JButton("─"));
		buttons.get(0).setBounds(327, FIRST_ITEM_SPACE, 41, 23);
		buttons.get(0).putClientProperty("index", 0);
		buttons.get(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItem((Integer) ((JButton) e.getSource()).getClientProperty("index"));
			}
		});
		add(buttons.get(0));

		btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
				btnAdd.setBounds(119, getSpaceBetweenItems(), 89, 23);
			}
		});
		btnAdd.setBounds(119, getSpaceBetweenItems(), 89, 23);
		add(btnAdd);
	}

	private void addItem() {
		int space = getSpaceBetweenItems();
		int index = items.size();

		items.add(new AttributesEditorItem());
		items.get(index).setLocation(10, space);
		add(items.get(index));

		buttons.add(new JButton("─"));
		buttons.get(index).setBounds(327, space, 41, 23);
		buttons.get(index).putClientProperty("index", index);
		buttons.get(index).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItem((Integer) ((JButton) e.getSource()).getClientProperty("index"));
			}
		});
		add(buttons.get(index));

		this.revalidate();
		this.repaint();
	}

	private void deleteItem(int index) {
		if (items.size() <= 1) {
			return;
		}

		remove(items.get(index));
		remove(buttons.get(index));

		items.remove(index);
		buttons.remove(index);

		adjustSpacing();

		btnAdd.setBounds(119, getSpaceBetweenItems(), 89, 23);

		revalidate();
		repaint();
	}

	private void adjustSpacing() {
		items.get(0).setLocation(10, FIRST_ITEM_SPACE);
		buttons.get(0).setBounds(327, FIRST_ITEM_SPACE, 41, 23);
		buttons.get(0).putClientProperty("index", 0);
		for (int i = 1; i < items.size(); i++) {
			items.get(i).setLocation(10, FIRST_ITEM_SPACE + i * SPACE_BETWEEN_ITEMS);
			buttons.get(i).setBounds(327, FIRST_ITEM_SPACE + i * SPACE_BETWEEN_ITEMS, 41, 23);
			buttons.get(i).putClientProperty("index", i);
		}
	}

	private int getSpaceBetweenItems() {
		return FIRST_ITEM_SPACE + items.size() * SPACE_BETWEEN_ITEMS;
	}

	public int getComponentSize() {
		int size = getSpaceBetweenItems() + 29;
		if (size < 279) {
			return 279;
		}
		return size;
	}
}
