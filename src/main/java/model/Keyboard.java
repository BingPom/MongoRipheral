package model;

import enums.KBLayout;
import enums.KBSize;
import enums.KBSwitches;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Keyboard extends Peripheral {
	private KBLayout layout;
	private KBSize size;
	private KBSwitches switches;

	public String toString() {
		return super.toString() + "\tLayout: " + layout + "\n\tTamaño: " + size + "\n\tSwitches: " + switches + "\n";
	}
}
