import java.io.IOException;
import java.io.File; 

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;

public class JsoupParser {
	
	ArrayList<WebPage> science = new ArrayList<WebPage>(); 
	ArrayList<WebPage> space = new ArrayList<WebPage>(); 
	ArrayList<WebPage> zombies = new ArrayList<WebPage>();
	
	public void readInFiles(){ //make this line main to test again
		
		Scanner scan;
		String url;
		File zombieFile = new File("zombieUrl.txt");
		File spaceFile = new File("spaceUrl.txt");
		File scienceFile = new File("scienceUrl.txt");
		String[] fileWords;
		WebPage<String> p;

		
		
		int count = 0;
		
		try{ 
			while(count <=15){
				if(count <= 5){
					scan = new Scanner(zombieFile);
					while(scan.hasNextLine()){
						url = scan.nextLine();
						//parse the url
					fileWords = JsoupParsing(url);
					
					p = new WebPage<String>(addWordsToBst(fileWords),url);
					zombies.add(p); //add that page to the category arraylist
					
					count++;	
					}//end scanner while
					scan.close();
				}//end if 5				
				else if(count >5 && count <=10){
					scan = new Scanner(spaceFile);
					while(scan.hasNextLine()){
						url = scan.nextLine(); 
						
						fileWords = JsoupParsing(url);
						
						p = new WebPage<String>(addWordsToBst(fileWords),url);
						space.add(p);
						
						count++;
					}//end while
					scan.close();
				}//end if greater then 5 and less then 10
				else{
					scan = new Scanner(scienceFile);
					while(scan.hasNextLine()){
						url = scan.nextLine();
						
						fileWords = JsoupParsing(url);
						
						p = new WebPage<String>(addWordsToBst(fileWords),url);
						science.add(p);
						
						count++;
					}// end while
					scan.close();
				}//end else (greater then 10)
			}//end while
		}//end try
		catch(IOException e){
			e.printStackTrace();
		}
	}//end main
	public static String[] JsoupParsing(String url) throws IOException{
		Document doc;
		String bodyText;
		
		//get the url
		doc = Jsoup.connect(url).get();
		
		// get the body text
		bodyText = doc.body().text();
			
	//replace all not text characters 
	String[] myList = bodyText.split("[^a-zA-Z0-9']+");
	return myList;
	}// end JsoupParsing 
	
	public static BasicBST addWordsToBst(String[] myWords){
		Random rand = new Random();
		BasicBST<String> bst = new BasicBST<String>();
		String zombieFileWord;
		for(String s:myWords){
			//pick a random word from the list
			zombieFileWord= myWords[rand.nextInt(myWords.length)];
			
			System.out.println(zombieFileWord);
			
			//add the words to the page object/bst
			bst.insert(zombieFileWord);
		}//end for
		return bst;
	}// end addWordsToBst
	
	public ArrayList<WebPage> getZombies(){
		return zombies;
	}
	public ArrayList<WebPage> getSpace(){
		return space;
	}
	public ArrayList<WebPage> getScience(){
		return science;
	}
}//end class