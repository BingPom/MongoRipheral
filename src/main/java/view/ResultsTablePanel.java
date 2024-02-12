package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import enums.Window;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResultsTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private String mode;
	private MainWindow parentFrame;

	/**
	 * Create the panel.
	 */
	public ResultsTablePanel(MainWindow frame, String mode) {
		this.setMode(mode);
		this.setParentFrame(frame);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 441, 329);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(
				new DefaultTableModel(getPeripherals(), getPeripheralsFields()) {
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(filtro);
		filtro.setRowFilter(RowFilter.regexFilter("", 0));

		JLabel lblText = new JLabel("Resultados de la búsqueda: ");
		lblText.setBounds(10, 11, 382, 14);
		add(lblText);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getParentFrame().goToCard(Window.Search_Main_Window);
			}
		});
		btnCancel.setBounds(10, 376, 89, 23);
		add(btnCancel);

//		If in search mode, it has no action (button) to do
		if (!this.getMode().equalsIgnoreCase("search")) {
			JButton btnAction = new JButton("Action");
			btnAction.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAction.setText("dasdasd");
					doAction();
				}
			});
			btnAction.setBounds(362, 376, 89, 23);
			add(btnAction);
		}
	}
	
	private String[] getPeripheralsFields() {
		// TODO Auto-generated method stub
		String[] result = {"cosa 1", "cosa 2"};
		return result;
	}

	private Object[][] getPeripherals() {
		Object[][] result = {{"1", "2"}, {"3", "4"}};
		return result;
	}

	private void doAction() {
		switch (this.getMode()) {
		case "edit":

			break;

		case "delete":

			break;
		default:
			break;
		}
		
		JOptionPane.showMessageDialog(getParentFrame(), "adsa");
	}
}
