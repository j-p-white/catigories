import java.io.IOException; 

import org.jsoup.*;
import org.jsoup.nodes.Document;

public class JsoupParser {
	
	public static void main(String [] args){
		Document doc; 
		String bodyText;
		try{ 
			//get the url
			doc = Jsoup.connect("http://www.nytimes.com/2014/02/04/science/blazing-trails-in-brain-science.html?ref=science&_r=0").get();
			
				// get the body text
				bodyText = doc.body().text();
				
				//replace all not text charecters 
		String[] myList = bodyText.split("[^a-zA-Z0-9']+");
				
			for(int i =0; i < myList.length;i++){
				System.out.println(myList[i]);
			}
			
		}//end try
		catch(IOException e){
			e.printStackTrace();
		}
		
	}//end main
}//end class