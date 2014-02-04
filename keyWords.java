import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Set;
import java.util.HashSet;
public class keyWords {
	static String line;
	static Set<String> sift;
    static URL news1; 
	
	// read in the file and check for regex
	public static void readFile() throws IOException{
	  news1 = new URL("http://www.nytimes.com");
    BufferedReader in = new BufferedReader(new InputStreamReader(news1.openStream()));
	    //while  information 
	    while((line = in.readLine())!= null){
		    //StringTokenizer tok = new StringTokenizer(line); //used to make the words nicer to work with
            
          System.out.println(keyWords(line));
	        //System.out.println(	line.replaceAll("<[^>]*>", "").trim());
	    }// end while 
	}// end readFile

    public static Set<String> keyWords(String myString){
        sift = new HashSet<String>(); 
        myString.trim();
        if(myString.toLowerCase().startsWith("<meta ")){
            if(myString.toLowerCase().matches("<meta name\\s?=\\s?\"keywords\"\\scontent\\s?=\\s?\".*\"/?>")){

                //get back the results

                myString = myString.replaceAll("(?i)<meta name\\s?=\\s?\"keywords\"\\scontent\\s?=\\s?\"(.*)\"/?>","$1");
                for (String s:myString.split(",")){

                    sift.add(s.trim());
                    return sift;
                }//end for

            }//end inner if 
           
        }//end meta if

        return null;
    }//end keyWords method

	public static void main(String[] args){
            try{
				readFile();
            }//end try
            catch(IOException e){ 
                e.printStackTrace();
            }//enc catch

	}// end main
}// end class
