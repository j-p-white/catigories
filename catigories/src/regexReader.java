import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
public class regexReader {
	static File textFile;
	static Scanner scan;
	static String line;
	static boolean start;
	static boolean end;
	static boolean garbage;
	
	// read in the file and check for regex
	public static void readFile() throws IOException{
	  URL economy1 = new URL("http://www.nytimes.com");

	  BufferedReader in = new BufferedReader(new InputStreamReader(economy1.openStream()));
try {
	Pattern startPattern = Pattern.compile("^[<p>]");
	Pattern endPattern = Pattern.compile("[</p>]$");
	Pattern p = Pattern.compile("[<a-zA-Z/.]*?>");
	
	//while  information 
	while((line = in.readLine())!= null){
		Matcher match = startPattern.matcher(line);
		Matcher endmatch = endPattern.matcher(line);
		Matcher gmatch = p.matcher(line);
		start = match.find();
		end = endmatch.find();
		garbage = gmatch.find();
		
	 
		//if the pattern matches <p>
		if(start){
			StringTokenizer tok = new StringTokenizer(line);
			//while the 2nd pattern is not </p> and has more elements 
			while(!end && tok.hasMoreElements()){	
					
				// if symbols are [< a-z/.>] ignore them 
				if(garbage){
					
				}
				//else print out the tokens
				else{
						System.out.println(tok.nextElement());
				}
					
		 }//end while
	 }//end if
	}// end while 
	
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  catch(NoSuchElementException e){
			  e.printStackTrace();
		}
	}// end readFile
	
	
	public static void main(String[] args){
			try {
				readFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
