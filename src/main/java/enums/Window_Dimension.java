package enums;

import java.awt.Dimension;

public enum Window_Dimension {
	Main_Window(new Dimension(435, 234)),
	;

    public final Dimension size;

    private Window_Dimension(Dimension size) {
        this.size = size;
    }
}
