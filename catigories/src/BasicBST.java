/*
 * 
 * Classname:BasicBST
 * 
 * Version information: 1
 *
 * Date: 2/9/2014
 * 
 * Copyright notice: none
 */
public class BasicBST <T extends Comparable<T>>   {
	 NaturalComparator<T> ordering = new NaturalComparator<T>();
	  
	 Node<T> rootnode; // is used every where
	 int treeScore;
	 boolean userSearch = false;
	 
	 //Node<T> delCurrent; // in use in delete method 
	  
	//BST null constructor - creates an empty tree
		public BasicBST() {
			rootnode = null;
		}//end BST null constructor

		//BST constructor
		public BasicBST(Node<T> node) {
			this.rootnode = node;
		}//end BST constructor
	  
		public void setBoolean(boolean b){
			userSearch = b;
		}//end setBool
		
		public int getScore(){
			return treeScore;
		}//end getScore method
	  
	    public Node<T> getRootnode()
		{
			return rootnode;
		}
		//this method needs to use weights when making nodes	
		public void insert(T name)
		{  
			//if the rootnode is null
			if(rootnode == null)
			{
				// make the 1st value the root // new could be bad
				rootnode = new Node<T>(name); 
			}
			//else 
		    else
			{ 
		    	//check for duplicates
		    	//if no duplicates 
				if(search(rootnode,name) == false)
				{
					//call the root insert 
				    insert(rootnode,name);
				} 
			}//end else
		}// end 1st insert
		
		//insert for placing nodes
		private void insert(Node<T> myNode, T val)  
		{	
			// if value is smaller then root, go left
			if ( ordering.compare(val,myNode.word) < 0)
			{
				// if root left is null 
				if(myNode.left == null)
				{
					// place the value to left of root 
					myNode.left = new Node<T>(val);

					//let the node keep track of its parent
					myNode.left.parent = myNode;
				} 
				else
				{	
					// go left more
					insert(myNode.left,val);
				} 
			}
			//if the value is bigger then the root, go right
			else if(ordering.compare(val,myNode.word) > 0)
			{
				//if right is null
				if (myNode.right == null)
				{ 
					//place the value to the right 
					myNode.right = new Node<T>(val);

					//let the new node remember it parents
					myNode.right.parent = myNode;
				}
				else 
				{ 
					//go more right
					insert(myNode.right,val);
				}
			}
		}// end insert
		public boolean find(T val)
		{
			return search(rootnode,val);
		}
		private boolean search(Node<T> temp, T val)
		{ 
			 if(temp==null)
			 {
				return false;
			 }
			 if(ordering.compare(val,temp.word) == 0)	 
			 {
				if(!userSearch){
					//increment the weight 
					temp.weight++;
				}
				else{
				    treeScore = treeScore + temp.weight;	
				}
				  return true; 	
			 }
			 else if(ordering.compare(val,temp.word) < 0)
			 {
				return(search(temp.left,val)); 
			 } 
			 else
			 { 
				return(search(temp.right,val)); 
			 }  
		}// end search
		
}//end class