package model;

import java.util.HashMap;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor

public class Peripheral {
	private String name;
	private Double price;
	private String brand;
	private String description;
	private String type;

	private HashMap<String, String> attributes;

	public String toString() {
		return name + "\t➡\n\tMarca: " + brand + "\n\tPrecio: " + price.toString() + "\n\tDescripcion: " + description
				+ "\n";
	}
	
	public Object[] toObjectArray() {
		Object[] result = new Object[5];
		result[0] = this.getName();
		result[1] = this.getType();
		result[2] = this.getBrand();
		result[3] = this.getPrice();
		result[4] = this.getDescription();
		return result;
	}
}
