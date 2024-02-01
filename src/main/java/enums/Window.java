package enums;

import java.awt.Dimension;

public enum Window {
	Main_Window("Main_Window", new Dimension(435, 234)),
	Search_Main_Window("Search_Main_Window", new Dimension(450, 281)),
	Add_Main_Window("Add_Main_Window", new Dimension(530, 370))
	;
	
//	JFrame bar takes 40px off the height (and maybe 10px of width)

	public final String name;
    public final Dimension size;

    private Window(String name, Dimension size) {
    	this.name = name;
        this.size = size;
    }
}
