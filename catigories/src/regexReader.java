import java.util.ArrayList;
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
	static boolean metaBool;
	static ArrayList<String> sift = new ArrayList<String>();
	
	// read in the file and check for regex
	public static void readFile() throws IOException{
	  URL economy1 = new URL("http://www.nytimes.com");

	  BufferedReader in = new BufferedReader(new InputStreamReader(economy1.openStream()));
try {
	//Pattern startPattern = Pattern.compile("^[<p>]*");
	//Pattern endPattern = Pattern.compile("[</p>]$*");
	//Pattern p = Pattern.compile("\s<[a-zA-Z\/][^>]*>\\g");
	//Pattern meta = Pattern.compile("[<metadata/^<]*?>");
	
	//while  information 
	while((line = in.readLine())!= null){
		StringTokenizer tok = new StringTokenizer(line);
		//Matcher match = startPattern.matcher(line);
		//Matcher endmatch = endPattern.matcher(line);
		//Matcher gmatch = p.matcher(line);
		//Matcher metaMatch = meta.matcher(line);
	//	start = match.find();
		//end = endmatch.find();
	//	garbage = gmatch.find();
		//metaBool = metaMatch.find();
		
		
	System.out.println(	line.replaceAll("<[^>]*>", "").trim());
		
	 /*
		//if the pattern matches <p>
		if(!garbage){
			
			//while the 2nd pattern is not </p> and has more elements 
			while(tok.hasMoreElements()){	
				//else print out the tokens			
						sift.add(tok.nextToken());	
		 }//end while
	 }//end if
	*/
	}// end while 
	
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  catch(NoSuchElementException e){
			  e.printStackTrace();
		}

		for(String g:sift){
			System.out.println(g);
		}
	}// end readFile
	
	
	public static void removeBadTokens(ArrayList<String> sift){
		String s;
		System.out.println("sift size is: "+ sift.size());
		for(int i =0; i < sift.size();i++){
			System.out.println(i);
			s = sift.get(i);
			s.replaceAll("<.", "");
			sift.add(i,s);
		}//end for
		
		for(String g:sift){
			System.out.println(g);
		}
	}// end method
	
	
	
	public static void main(String[] args){
			try {
				readFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch 
		//	removeBadTokens(sift);
	}// end main
	
}
