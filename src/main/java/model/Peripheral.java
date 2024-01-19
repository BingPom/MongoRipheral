package model;

import enums.PeripheralType;
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
	private PeripheralType type;

	public String toString() {
		return name + " -> [ Tipo: " + type.toString() + ", Precio: " + price.toString() + ", Descripcion: "
				+ description + "]";
	}
}
