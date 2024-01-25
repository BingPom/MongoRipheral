package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.setBounds(218, 133, 79, 23);
		
		JButton btnDelete = new JButton("Borrar");
		btnDelete.setBounds(317, 133, 79, 23);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.setBounds(20, 133, 79, 23);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.setBounds(119, 133, 79, 23);
		
		JLabel lblSelectOption = new JLabel("Seleccione una opción:");
		lblSelectOption.setBounds(30, 101, 109, 14);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("BIENVENIDO A MONGORIPHERAL");
		lblWelcome.setBounds(30, 37, 359, 29);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblWelcome);
		contentPane.add(lblSelectOption);
		contentPane.add(btnAdd);
		contentPane.add(btnUpdate);
		contentPane.add(btnSearch);
		contentPane.add(btnDelete);
	}
}
