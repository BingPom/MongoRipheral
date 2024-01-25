package model;

import enums.Connectivity;
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
}
