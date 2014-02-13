import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
public class Test {

	
	public static void main(String[]args) throws IOException{
		
		basicTreeWeighting(); //bst works properly
		populatePageObject();// page method works properly
		populatePageFromArray(); //a score is produced
		testJsoupMethods(); // produced a score -score changes each time - that is a bug 
		testJsoupRun(); // made a score for that category
		testScoreChanging();// check what the zombie page scores are
		
		
	}//end main
	public static void basicTreeWeighting(){
		BasicBST<String> tree = new BasicBST<String>(); 
		String [] testAdd = {"cars","cars","cars"};
		
		tree.insert("cars");
		tree.insert("cats");
		tree.insert("bugs");
		
		System.out.println("root name: "+tree.getRootnode().word+" "+"root weight: "+tree.getRootnode().weight);
		tree.insert("cars");
		System.out.println("root name: "+tree.getRootnode().word+" "+"root weight: "+tree.getRootnode().weight);
		tree.insert("Cars");
		
		tree.setBoolean(true);
		
	     for(String s:testAdd){
	    	 tree.insert(s);
	     }
		System.out.println(tree.getScore());
	}//end basicTreeWeighting
	
	public static void populatePageObject(){
		WebPage<String> page = new WebPage<String>();
		String w1 = "cat";
		
		page.pageWords.insert(w1);
		page.pageWords.insert(w1);
		page.pageWords.insert(w1);
		page.pageWords.insert(w1);
		
		page.pageWords.setBoolean(true);
		
		page.pageWords.find(w1);
		
		System.out.println(" page score test: "+page.pageWords.getScore());
	}
	
	public static void populatePageFromArray(){
		ArrayList<WebPage<String>> testArray = new ArrayList<WebPage<String>>();
		Random rand = new Random();
		int score = 0;
		String [] testAdd = {"cats","cats","cats","cats"};
		WebPage<String> page = new WebPage<String>();
	while(testArray.size() < 5){
		for(String s: testAdd){
			page.pageWords.insert(testAdd[rand.nextInt(testAdd.length)]);
		}
	 testArray.add(page);
	}// end while
	
		for(WebPage<String> p:testArray){
			p.pageWords.setBoolean(true);
			p.pageWords.find("cats");
			score += p.pageWords.getScore(); //score is way to high
		}
		System.out.println("score is: "+ score);
	}//end method
	
	public static void testJsoupMethods() throws IOException{
		String [] words;
		BasicBST<String> b = new BasicBST<String>();
		int score = 0;
		JsoupParser parse = new JsoupParser();
		WebPage<String> p = new WebPage<String>();
		
		words = parse.JsoupParsing("http://en.wikipedia.org/wiki/Zombie"); //not in lower case
			
		   b = JsoupParser.addWordsToBst(words);
		   
		   p = new WebPage<String>(b,"http://en.wikipedia.org/wiki/Zombie");
			
			for(String s:words){
				p.pageWords.setBoolean(true);
				p.pageWords.find(s);
				
			}
			score += p.pageWords.getScore(); //score is way to high
			System.out.println("JsoupTest: "+score); //precentage for score
	}// end jsoup test
	
	public static void testJsoupRun() throws IOException{ 
		ArrayList<WebPage<String>> array = new ArrayList<WebPage<String>>();
		JsoupParser parse = new JsoupParser();
		String [] words;
		int score =0;
		words = parse.JsoupParsing("http://en.wikipedia.org/wiki/Zombie"); //not in lower case
		
		parse.readInFiles();
		
		array = parse.getZombies(); 
		
		for(WebPage<String>w: array){
			w.pageWords.setBoolean(true);
			for(String s : words){
				w.pageWords.find(s);
			score += w.pageWords.getScore();
			}// end for
		}
		System.out.println("JsoupRunTest: "+score);
	}// end JsoupRun
public static void testScoreChanging(){
	boolean quit = false;
	boolean ButtonClick = true;
	JsoupParser parser = new JsoupParser(); 
	
	parser.readInFiles();
	
	for (WebPage<String> p:parser.getZombies()){
		System.out.println("Zombie page Scores: "+p.pageScore);	
		
	}//end for
}//end method
	
	
	
	
}//end text class
