
public class Node<T extends Comparable<T>>{

	Node<T> left,right,parent; 
	int weight; 
	T word; 
	
	public Node(){
		
	}//end empty constructor
	
	public Node(T name, int numb){
		word = name; 
		weight = numb;
	}
	
	public Node(T name){
		word = name;
	}
	
}//end class
