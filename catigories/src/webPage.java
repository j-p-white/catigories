
public class webPage<T>{
	
	BasicBST<?> pageWords;
	String websiteName; 
	
	public webPage(BasicBST<?> bst, String url){
		pageWords = bst; 
		websiteName = url;
	}//end basic webpage 
	
	public webPage(){
		
	}// end empty constructor
	
	
}//end class
