// program to implement a binary serach tree.
// includes:
// 1. adding nodes to the tree (displays message when duplicate node is input)
// 2. tree traversals (in-order, pre-order, post-order, level-order)
// 3. converts tree toString, in-order format
public class treeTraversal{
	
	node root;
	
	public class node
	{
		node left;
		node right;
		Object data;
		
		// default node constructor
		// sets everything to null
		public node()
		{			
		}
		
		// parameterized constructor
		// sets the new node's data value to inputData
		public node(int inputData)
		{
			data = inputData; 
			left = null;
			right = null;
		}
	}
	
	// default tree constructor
	//creates a new root node and sets all its configs to null
	public treeTraversal()
	{
		root = new node();
	}
	
	// parameterized tree constructor
	// create a tree node, with no children and null links, with value input
	public treeTraversal(int input)
	{
		root = new node(input);
	}
	
	// does not allow user to add duplicate values <binary tree rule>
	// checks for the order of the input value and adds it at appropriate position. 
	public void addToTree(int inputVal)
	{
		if (root == null)
		{
			root = new node(inputVal);
			return;
		}
	
		node temp = root;
		node tempp;
		while(true)
		{
			tempp = temp;
			if((int)temp.data > inputVal)
			{
				temp = temp.left;
				if(temp == null)
				{
					tempp.left = new node(inputVal);
					return;
				}				 
			}
			
			else if((int)temp.data < inputVal)
			{
				temp = temp.right;
				if(temp == null)
				{
					tempp.right = new node(inputVal);
					return;
				}		
			}
			
			else
			{
				System.out.println("Input Value already exists, hence value: " +inputVal +" cannot be added to the binary tree");
				return;
			}			
		}
	}
	
	@Override
	public String toString()
	{
	return toString(this.root);	
	}
	
	// return in-order traversal string of the tree.
	public String toString(node start)
	{
		 if (start == null) 
		 {
		        return null;
		 }
		 
		 return "[" + toString(start.left) + "," + start.data + "," + toString(start.right) + "]";
	}
	
	// function to implement pre-order traversal
	public void preOrder(node start)
	{
		if (start != null) 
		{		 
			System.out.println(start.data);
			preOrder(start.left);
			preOrder(start.right);
		}
	}
	
	// function to implement in-order traversal
	public void inOrder(node start)
	{
		if (start != null) 
		{
			inOrder(start.left);
			System.out.println(start.data);
			inOrder(start.right);
		}
	}
	
	// function to implement post-order traversal
	public void postOrder(node start)
	{
		if (start != null) 
		{
			postOrder(start.left);
			postOrder(start.right);
			System.out.println(start.data);
		}
	}
	
	// function to implement level-order traversal
	public void levelOrder(node start)
	{
		
	}
	
	public static void main(String[] args)
	{
		treeTraversal bTree = new treeTraversal(5);
		bTree.addToTree(1);
		bTree.addToTree(4);
		bTree.addToTree(4);
		bTree.addToTree(3);
		bTree.addToTree(7);
		
		System.out.println(bTree.toString());
		System.out.println("***Pre-Order Traversal***"); bTree.preOrder(bTree.root);
		System.out.println("***In-Order Traversal***"); bTree.inOrder(bTree.root);
		System.out.println("***Post-Order Traversal***"); bTree.postOrder(bTree.root);
	}
}
