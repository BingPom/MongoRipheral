package model;

import enums.AudioType;
import enums.Connectivity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Headset extends Peripheral {
	private Connectivity connectivity;
	private AudioType audio;

	public String toString() {
		return super.toString() + "\tConectividad: " + connectivity + "\n\tAudio: " + audio + "\n";
	}
}
