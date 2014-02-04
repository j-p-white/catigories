
public class Node<T extends Comparable<T>>{

	Node<T> left,right,parent; 
	int weight; 
	String url; 
	
	public Node(){
		
	}//end empty constructor
	
	public Node(String name, int numb){
		url = name; 
		weight = numb;
	}//end constructor
}//end class
