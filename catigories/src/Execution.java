
/*
 * Classname:BasicBST
 * 
 * Version information: 1
 *
 * Date: 2/9/2014
 * 
 * Copyright notice: none
 */
public class Execution {
	static String [] usersWords;
	public static void main(String[] args) {
		//variables
		JsoupParser parser = new JsoupParser(); 
		GuiPage gui = new GuiPage();
		
		parser.readInFiles(); // run the parser 
		gui.runGui(); // run the gui 
	
	}// end main
}//end class