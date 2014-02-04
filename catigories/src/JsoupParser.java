import java.io.IOException; 

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupParser {
	
	public static void main(String [] args){
		Document doc; 
		String keyWords;
		String bodyText;
		Elements link; 
		
		try{ 
			
			//get the url
			doc = Jsoup.connect("http://www.nytimes.com/2014/02/04/science/blazing-trails-in-brain-science.html?ref=science&_r=0").get();
			
			
			
		}//end try
		catch(IOException e){
			e.printStackTrace();
		}
		
	}//end main
	
	
	

}
