// program to create a binary search tree with minimal height
// given a sorted (increasing order) array with unique integer elements

public class third{
	
	// tree node class
	public static class node
	{
		node left;
		node right;
		int data;
	
		public node(int input)
		{
			data = input;
		}
	}
	
	// create a BST from the given array
	public static node createBST(int[] inputArray)
	{
		return createTree(inputArray, 0, inputArray.length - 1);
	}
	
	// helper function 
	// parameters : array, beginning and ending index of array in consideration
	// returns: the root node of the main array
	public static node createTree(int[] A, int start, int end)
	{
		// base case
		if(end < start)
			return null;
		
		// point of partition
		int mid = (start + end)/ 2;
		
		// create new node to be added
		node main = new node(A[mid]);
		
		// recursively create the left and right branch nodes with the 
		// first half and second half of the array minus the A[mid] element.
		main.left = createTree(A, start, mid-1);
		main.right = createTree(A,mid+1,end);
		
		// return the main root node
		return main;
	}
	
	// converts the tree to string format
	// prints in in-order traversal format 
	static String toString(node start)
	{
		if(start == null)
		 return "";	
	
		return (" " + toString(start.left) + " " + start.data + " " + toString(start.right)+ " ");
	}

	public static void main(String[] args)
	{
		
		int[] testArray = {19, 22, 43, 56, 76, 89};
		
		node root = createBST(testArray);
		
		System.out.println(toString(root));
			
		
	}


}