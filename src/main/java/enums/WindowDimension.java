package enums;

import java.awt.Dimension;

public enum WindowDimension {
	Main_Page(new Dimension(435, 234)),
	Filter_Page(new Dimension(450, 281)),
	Table_Page(new Dimension(470,450)),
	Attributes_Page(new Dimension(540, 573))
	;
	
	public final Dimension size;
	
	private WindowDimension(Dimension size) {
		this.size = size;
	}
}
