
public class WebPage<T>{
	
	BasicBST<String> pageWords;
	String websiteName; 
	
	public WebPage(BasicBST<String> bst,String url){
		pageWords = bst; 
		websiteName = url;
		
	}//end basic webpage 
	
	public WebPage(){
		
	}// end empty constructor
	
	public WebPage(String word){
		
	}
	
	public void setwebsiteName(String url){
		websiteName = url;
	}
	
}//end class
