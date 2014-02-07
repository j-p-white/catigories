import java.util.ArrayList;

/*
 * Classname
 * 
 * Version information
 *
 * Date
 * 
 * Copyright notice
 */
public class Execution {
	static String [] usersWords;
	public static void main(String[] args) {
		//variables
		JsoupParser parser = new JsoupParser(); 
		GuiPage gui = new GuiPage();
		int zombieScore; 
		int spaceScore; 
		int scienceScore; 
		
		parser.readInFiles(); // run the parser 
		
		
		gui.runGui(); // run the gui 
		
		//get the scores for each of the categories
		scienceScore = scoreCategories(usersWords,parser.getScience());
		spaceScore = scoreCategories(usersWords,parser.getSpace());
		zombieScore = scoreCategories(usersWords,parser.getZombies());
		
		System.out.println("scienceScore: "+ scienceScore);
		

	}// end main

	public void setUserWords(String [] words){
		usersWords = words;
	}// end setUserWOrds
	public static int scoreCategories(String[] DLwords,ArrayList<WebPage> categorie){
	int count =0;
	int catScore = 0;
		for(WebPage p: categorie){
			for(String s:DLwords){
				p.pageWords.find(s);
			}//end DLwords for
		catScore += p.pageWords.getScore();
		}//end categories for
	  return catScore;
	}// end method
	
	
}// end class
