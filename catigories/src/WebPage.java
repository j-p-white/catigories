/*
 * Classname:BasicBST
 * 
 * Version information: 1
 *
 * Date: 2/9/2014
 * 
 * Copyright notice: none
 */
public class WebPage<T>{
	
	BasicBST<String> pageWords = new BasicBST<String>();
	String websiteName; 
	int pageScore;
	
	public WebPage(BasicBST<String> bst,String url){
		pageWords = bst; 
		websiteName = url;
	}//end basic webpage 
	
	
	
	public WebPage(){
		
	}// end empty constructor
	
	public void setPageScore(int score){
		pageScore += score;
	}
	
}//end class
