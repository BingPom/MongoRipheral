package enums;

import java.awt.Dimension;

public enum WindowDimension {
	Main_Page(new Dimension(445, 234)),
	Filter_Page(new Dimension(450, 281)),
	Table_Page(new Dimension(480,450)),
	Attributes_Page(new Dimension(540, 573))
	;
	
//	JFrame bar takes 40px off the height (and maybe 10px of width)
	
	public final Dimension size;
	
	private WindowDimension(Dimension size) {
		this.size = size;
	}
}
