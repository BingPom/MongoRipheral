package view.components;

import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PriceRangeSelector extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PriceRangeSelector frame = new PriceRangeSelector();
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
	public PriceRangeSelector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		JLabel lblLeftSide = new JLabel("Desde ");
		contentPane.add(lblLeftSide);
		
		SpinnerNumberModel priceSpinnerModelMinPrice = new SpinnerNumberModel(0d, 0d, 500d, 1.00d);
		JSpinner spinnerMinPrice = new JSpinner(priceSpinnerModelMinPrice);
		spinnerMinPrice.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
					priceSpinnerModelMinPrice.setValue(spinnerMinPrice.getMaximumSize());
			}
		});
		JSpinner.NumberEditor editorMinPrice = new JSpinner.NumberEditor(spinnerMinPrice, "#,##0.00");
		JFormattedTextField textFieldMinPrice = editorMinPrice.getTextField();
		textFieldMinPrice.setColumns(4);
        spinnerMinPrice.setEditor(editorMinPrice);
		contentPane.add(spinnerMinPrice);
		
		JLabel lblInBetween = new JLabel(" hasta ");
		contentPane.add(lblInBetween);
		
		JSpinner spinnerMaxPrice = new JSpinner();
		contentPane.add(spinnerMaxPrice);
		
		JLabel lblRightSide = new JLabel(" €");
		contentPane.add(lblRightSide);
	}
}
