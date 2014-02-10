import java.io.IOException;
import java.io.File; 
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
/*
 * Classname:BasicBST
 * 
 * Version information: 1
 *
 * Date: 2/9/2014
 * 
 * Copyright notice: none
 */
public class JsoupParser {
	
	ArrayList<WebPage<String>> science = new ArrayList<WebPage<String>>(); 
	ArrayList<WebPage<String>> space = new ArrayList<WebPage<String>>(); 
	ArrayList<WebPage<String>> zombies = new ArrayList<WebPage<String>>();
	
	public void readInFiles(){ //make this line main to test again
		
		Scanner scan;
		String url;
		File zombieFile = new File("zombieUrl.txt");
		File spaceFile = new File("spaceUrl.txt");
		File scienceFile = new File("scienceUrl.txt");
		String[] fileWords;
		WebPage<String> p = new WebPage<String>();
		boolean endWhile = true;
		try{ 
			while(endWhile){
				if(zombies.size() <=0){
					scan = new Scanner(zombieFile);
					while(scan.hasNextLine()){
						url = scan.nextLine();
						//parse the url
					fileWords = JsoupParsing(url);
					
					p = new WebPage<String>(addWordsToBst(fileWords),url);
					zombies.add(p); //add that page to the category arraylist
						
					}//end scanner while
					scan.close();
				}//end if 5				
				
			 if(science.size() <=0){
				 scan = new Scanner(scienceFile);
				 while(scan.hasNextLine()){
					 url = scan.nextLine();
					 fileWords = JsoupParsing(url);
					 
					 p = new WebPage<String>(addWordsToBst(fileWords),url);
					 science.add(p);
				 }//end while
				 scan.close();
			 }// end science if
			 
			 if(space.size() <=0){
				 scan = new Scanner(spaceFile);
				 while(scan.hasNextLine()){
					 url = scan.nextLine();
					 fileWords = JsoupParsing(url);
					 
					 p = new WebPage<String>(addWordsToBst(fileWords),url);
					 space.add(p);
				 }//end while
				 scan.close();
				 endWhile = false;
			 }// end space if
			}// end while
		}//end try
		catch(IOException e){
			e.printStackTrace();
		}
	}//end readInFile
	
	public String[] JsoupParsing(String url) throws IOException{
		Document doc;
		String bodyText;
		
		//get the url
		doc = Jsoup.connect(url).get();
		
		// get the body text
		bodyText = doc.body().text();
		
		bodyText.toLowerCase();
			
	//replace all not text characters 
	String[] myList = bodyText.split("[^a-zA-Z0-9']+");
	return myList;
	}// end JsoupParsing 
	
	public static BasicBST<String> addWordsToBst(String[] myWords){
		Random rand = new Random();
		BasicBST<String> bst = new BasicBST<String>();
		String fileWord;
		for(String s:myWords){
			//pick a random word from the list
			fileWord= myWords[rand.nextInt(myWords.length)];
			
			System.out.println(fileWord);
			
			//add the words to the page object/bst
			bst.insert(fileWord.toLowerCase());
		}//end for
		return bst;
	}// end addWordsToBst
	
	public ArrayList<WebPage<String>> getZombies(){
		return zombies;
	}
	
	
	public ArrayList<WebPage<String>> getSpace(){
		return space;
	}
	
	
	public ArrayList<WebPage<String>> getScience(){
		return science;
	}
}//end class