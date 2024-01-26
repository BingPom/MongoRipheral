package model;

import enums.Connectivity;
import enums.MSensorType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Mouse extends Peripheral {
	private Connectivity connectivity;
	private String sensor;
	private MSensorType sensorType;

	public String toString() {
		return super.toString() + "\tSensor type: " + sensorType + "\n\tSensor model: " + sensor + "\n\tConectividad: "
				+ connectivity + "\n";
	}
}
