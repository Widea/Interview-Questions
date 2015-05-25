import java.util.LinkedList;
import java.util.Queue;

// program to implement a binary search tree.
// includes:
// 1. adding nodes to the tree (displays message when duplicate node is input)
// 2. tree traversals (in-order, pre-order, post-order, level-order)
// 3. converts tree toString, in-order format
// 4. searches for a given value in the BST
// 5. calculates the height of the tree, with the assumption that the height of an empty tree is 0.

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
	
	// calculates the height of the tree
	// assumption: height of an empty tree is 0
	public static int height(node start)
	{
		if(start == null)
			return 0;
		
		return 1 + Math.max(height(start.left), height(start.right));
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
		Queue<node> nodequeue = new LinkedList<node>();		
		
		if(start == null)
		return;
		
		nodequeue.add(start);
		while(!nodequeue.isEmpty())
		{		
			node temp = nodequeue.remove();		
			System.out.println(temp.data);			

			if(temp.left != null)
			{
				nodequeue.add(temp.left);
			}
		
			if(temp.right != null)
			{
				nodequeue.add(temp.right);
			}
		}		
	}
	
	// function implementing searching in BST
	public boolean searchTree(Integer inputValue)
	{
		if(root == null || inputValue == null)
			return false;
		
		node temp = root;
		
		while(temp != null)
		{
			if((Integer)temp.data == inputValue )
				return true;
			else if((Integer)temp.data > inputValue )
				temp = temp.left;
			else
				temp = temp.right;			
		}
		
		return false;
		
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
		
		// display tree height
		System.out.println("The height of the tree is: " + height(bTree.root));
		
		System.out.println("***Pre-Order Traversal***"); bTree.preOrder(bTree.root);
		System.out.println("***In-Order Traversal***"); bTree.inOrder(bTree.root);
		System.out.println("***Post-Order Traversal***"); bTree.postOrder(bTree.root);
		System.out.println("***Level-Order Traversal***"); bTree.levelOrder(bTree.root);
		
		System.out.println();
		
		System.out.println("***Searching***");
		
		// negative test cases
		System.out.println("Tree contains 22? " +bTree.searchTree(22));
		System.out.println("Tree contains 10? " +bTree.searchTree(10));
		System.out.println("Tree contains null? " +bTree.searchTree(null));
		
		// positive test cases
		System.out.println();
		System.out.println("Tree contains 1? " +bTree.searchTree(1));
		System.out.println("Tree contains 5? " +bTree.searchTree(5));
		System.out.println("Tree contains 7? " +bTree.searchTree(7));

	}
}
