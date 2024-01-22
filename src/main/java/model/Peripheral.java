package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Peripheral {
	private String id;
	private String name;
	private Double price;
	private String description;
	private String brand;

	public String toString() {
		return name + "\t➡\n\tMarca: " + brand + "\n\tPrecio: " + price.toString() + "\n\tDescripcion: " + description
				+ "\n";
	}
}
