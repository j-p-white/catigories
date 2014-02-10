/*
 * Classname:BasicBST
 * 
 * Version information: 1
 *
 * Date: 2/9/2014
 * 
 * Copyright notice: none
 */
public class Node<T extends Comparable<T>>{

	Node<T> left,right,parent; 
	int weight = 1; 
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
