import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
public class regexReader {
	static File textFile;
	static Scanner scan;
	static String line;
	static boolean found;
	
	// read in the file and check for regex
	public static void readFile(){
		textFile = new File("regex.txt");
		try {
			scan = new Scanner(textFile);
		

	Pattern p = Pattern.compile("[^<a-zA-Z/^<]*?>");
	
	while(scan.hasNext()){
	line = scan.next();
	Matcher match = p.matcher(line);
	 found = match.find();
	 if(!found){
		 StringTokenizer tok = new StringTokenizer(line);
		//print out all tokens 
		  while(tok.hasMoreElements()){
			  System.out.println(tok.nextElement());
		  }//end while
	 }//end if
	}// end while 
	
	scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  catch(NoSuchElementException e){
			  e.printStackTrace();
		}
	}// end readFile
	
	
	public static void main(String[] args){
			readFile();
	}
	
}
