package view.components;

import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PriceSelector extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private double price;
	private JSpinner spinnerPrice;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
//		Check below zero
		if (price < 0) {
			this.price = 0;
			return;
		}
//		If all checks passed, assign new value
		this.price = price;
	}
	public void updatePrice(double price) {
		this.setPrice(price);
		spinnerPrice.setValue(this.getPrice());
	}


	/**
	 * Create the panel.
	 */
	public PriceSelector(double startingPrice) {
		SpinnerNumberModel priceSpinnerModelPrice = new SpinnerNumberModel(startingPrice, 0d, null, 1.00d);
		spinnerPrice = new JSpinner(priceSpinnerModelPrice);
		spinnerPrice.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setPrice((double) spinnerPrice.getValue());
				spinnerPrice.setValue(getPrice());
			}
		});
		JSpinner.NumberEditor editorPrice = new JSpinner.NumberEditor(spinnerPrice, "#,##0.00");
		JFormattedTextField textFieldPrice = editorPrice.getTextField();
		textFieldPrice.setColumns(4);
		spinnerPrice.setEditor(editorPrice);
		add(spinnerPrice);
	}

	public void setEditable(boolean enabled) {
		spinnerPrice.setEnabled(enabled);
	}
	
}
