package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import enums.Window;
import lombok.Data;
import lombok.EqualsAndHashCode;
import model.Peripheral;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResultsTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String mode;
	private ArrayList<Peripheral> peripherals = new ArrayList<Peripheral>();
	private DefaultTableModel tableModel = new DefaultTableModel(getPeripheralsData(), getPeripheralsFields()) {
		private static final long serialVersionUID = 1L;
		boolean[] columnEditables = new boolean[] { false, false, false, false, false };
		
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
	private JTable table;
	private MainWindow parentFrame;

	public void updateTable(ArrayList<Peripheral> peripherals) {
		setPeripherals(peripherals);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setDataVector(getPeripheralsData(), getPeripheralsFields());
	}
	
	/**
	 * Create the panel.
	 */
	public ResultsTablePanel(MainWindow frame, String mode, Window previousWindow, Window nextWindow) {
		this.setMode(mode);
		this.setParentFrame(frame);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 441, 329);
		add(scrollPane);

		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModel);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(150);
		tcm.getColumn(1).setPreferredWidth(150);
		tcm.getColumn(2).setPreferredWidth(150);
		tcm.getColumn(3).setPreferredWidth(100);
		tcm.getColumn(4).setPreferredWidth(250);
		TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(filtro);
		filtro.setRowFilter(RowFilter.regexFilter("", 0));

		JLabel lblText = new JLabel("Resultados de la búsqueda: ");
		lblText.setBounds(10, 11, 382, 14);
		add(lblText);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getParentFrame().goToCard(previousWindow);
			}
		});
		btnCancel.setBounds(10, 376, 89, 23);
		add(btnCancel);

		JButton btnAction = new JButton("Select");
		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(nextWindow);
			}
		});
		btnAction.setBounds(362, 376, 89, 23);
		add(btnAction);
	}

	private String[] getPeripheralsFields() {
		String[] result = { "Nombre", "Tipo", "Marca", "Precio", "Descripcion" };
		return result;
	}

	private Object[][] getPeripheralsData() {
		return toObjectMatrix(this.getPeripherals());
	}
	
	private Object[][] toObjectMatrix(ArrayList<Peripheral> peripherals) {
		Object[][] result = new Object[peripherals.size()][getPeripheralsFields().length];
		for (int i = 0; i < result.length; i++) {
			result[i] = peripherals.get(i).toObjectArray(); 
		}
		return result;
	}
	
	private void doAction(Window nextWindow) {
		switch (this.getMode()) {
		case "edit":

			break;
		case "delete":
			JOptionPane.showMessageDialog(getParentFrame(), "adsa");
			this.getParentFrame().goToCard(nextWindow);
			break;
		case "search":
			if (table.getSelectedRow() >= 0) {
				AttributesEditorPanel a = (AttributesEditorPanel) this.getParentFrame().getClassByWindow(nextWindow);
				a.setPeripheral(getPeripherals().get(table.getSelectedRow()));
				this.getParentFrame().goToCard(nextWindow);			
			} else {
				JOptionPane.showMessageDialog(parentFrame, "Ningún periférico seleccionado, seleccione uno antes de continuar");
			}
			break;
		default:
			break;
		}
	}
}
