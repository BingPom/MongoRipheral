package view.components;


import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

public class PriceRangeSelector extends JPanel {

	private static final long serialVersionUID = 1L;

	private double cielingPrice;
	private double minPrice;
	private double maxPrice;

	public double getMinPrice() {
		return minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public double getCielingPrice() {
		return cielingPrice;
	}
	public void setCielingPrice(double cielingPrice) {
		this.cielingPrice = cielingPrice;
	}
	public void setMinPrice(double minPrice) {
//		Check below zero
		if (minPrice < 0) {
			this.minPrice = 0;
			return;
		}
//		Check above current max price
		if (minPrice > this.getMaxPrice()) {
			this.minPrice = this.getMaxPrice();
			return;
		}
//		Check above cieling
		if (minPrice > this.getCielingPrice()) {
			this.minPrice = this.getMaxPrice();
			return;
		}
//		If all checks passed, assign new value
		this.minPrice = minPrice;
	}
	public void setMaxPrice(double maxPrice) {
//		Check below zero
		if (maxPrice < 0) {
			this.maxPrice = 0;
			return;
		}
//		Check below current min price
		if (maxPrice < this.getMinPrice()) {
			this.maxPrice = this.getMinPrice();
			return;
		}
//		Check above cieling
		if (maxPrice > this.getCielingPrice()) {
			this.maxPrice = this.getCielingPrice();
			return;
		}
//		If all checks passed, assign new value
		this.maxPrice = maxPrice;
	}

	/**
	 * Create the component.
	 */
	public PriceRangeSelector(double startingMinPrice, double startingMaxPrice, double cielingPrice) {
//		Assign to attributes
		this.setCielingPrice(cielingPrice);
		this.setMinPrice(startingMinPrice);
		this.setMaxPrice(startingMaxPrice);
		
//		"Desde" label
		JLabel lblLeftSide = new JLabel("desde ");
		add(lblLeftSide);

//		First Spinner
		SpinnerNumberModel priceSpinnerModelMinPrice = new SpinnerNumberModel(startingMinPrice, 0d, null, 1.00d);
		JSpinner spinnerMinPrice = new JSpinner(priceSpinnerModelMinPrice);
		spinnerMinPrice.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setMinPrice((double) spinnerMinPrice.getValue());
				spinnerMinPrice.setValue(getMinPrice());
			}
		});
		JSpinner.NumberEditor editorMinPrice = new JSpinner.NumberEditor(spinnerMinPrice, "#,##0.00");
		JFormattedTextField textFieldMinPrice = editorMinPrice.getTextField();
		textFieldMinPrice.setColumns(4);
		spinnerMinPrice.setEditor(editorMinPrice);
		add(spinnerMinPrice);

//		"hasta" label
		JLabel lblInBetween = new JLabel(" hasta ");
		add(lblInBetween);
		
//		Second Spinner
		SpinnerNumberModel priceSpinnerModelMaxPrice = new SpinnerNumberModel(startingMaxPrice, 0d, cielingPrice, 1.00d);
		JSpinner spinnerMaxPrice = new JSpinner(priceSpinnerModelMaxPrice);
		spinnerMaxPrice.addChangeListener(new ChangeListener() {	
			@Override
			public void stateChanged(ChangeEvent e) {
				setMaxPrice((double) spinnerMaxPrice.getValue());
				spinnerMaxPrice.setValue(getMaxPrice());
			}
		});
		JSpinner.NumberEditor editorMaxPrice = new JSpinner.NumberEditor(spinnerMaxPrice, "#,##0.00");
		JFormattedTextField textFieldMaxPrice = editorMaxPrice.getTextField();
		textFieldMaxPrice.setColumns(4);
		spinnerMaxPrice.setEditor(editorMaxPrice);
		add(spinnerMaxPrice);
		
//		"€" label
		JLabel lblRightSide = new JLabel(" €");
		add(lblRightSide);
	}
}
