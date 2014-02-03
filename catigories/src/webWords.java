import java.net.*; 
import java.io.*;


public class webWords{
  public static void main(String[]args) throws Exception { 

      URL economy1 = new URL("http://www.nytimes.com/2014/01/31/business/us-economy-grew-3-2-in-fourth-quarter.html?hp&_r=0");

      BufferedReader in = new BufferedReader(new InputStreamReader(economy1.openStream()));

      String inputLine;
      while ((inputLine = in.readLine()) !=null){
             System.out.println(inputLine);
             System.out.println(" in while");
       }//end while
       in.close();      
       
  }// end main  
}//end class 
