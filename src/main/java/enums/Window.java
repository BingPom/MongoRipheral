package enums;

import java.awt.Dimension;

public enum Window {
	Main_Window("Main_Window", WindowDimension.Main_Page),
	
	Search_Main_Window("Search_Main_Window", WindowDimension.Filter_Page),
	Search_Result_Table("Search_Result_Table", WindowDimension.Table_Page),
	Search_Attributes_Viewer("Search_Attributes_Viewer", WindowDimension.Attributes_Page),
	
	Add_Main_Window("Add_Main_Window", WindowDimension.Attributes_Page),
	
	Update_Main_Window("Update_Main_Window", WindowDimension.Table_Page),
	Update_Attributes_Editor("Update_Attributes_Editor", WindowDimension.Attributes_Page),
	
	Delete_Main_Window("Delete_Main_Window", WindowDimension.Table_Page),
	Delete_Attributes_Editor("Delete_Attributes_Editor", WindowDimension.Attributes_Page)
	;
	
//	JFrame bar takes 40px off the height (and maybe 10px of width)

	public final String name;
    public final Dimension size;

    private Window(String name, WindowDimension size) {
    	this.name = name;
        this.size = size.size;
    }
}
