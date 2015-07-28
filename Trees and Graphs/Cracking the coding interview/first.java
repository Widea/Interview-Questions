/* Cracking the coding interview
 * Chapter : Trees and Graphs
 * Question: 4.1
 * Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is defined 
 * to be a tree such that the heights of the two 
 * subtrees of any node never differ by more than one.
 * Author : Viveka Aggarwal
 */
 
public class first{
	
	// tree node
	public static class node
	{
		Object data;
		node left;
		node right;
	
		node(Object inputData)
		{
			data = inputData;
			left = right = null;
		}
	}
	
	// method I (calculate height at each node and recurse through the tree. If unbalanced return false)
	public static int height1(node start)
	{		
		if(start == null)
			return 0;
		
		return  1 + Math.max(height1(start.left), height1(start.right));		
	}
	
	public static boolean isBalanced1(node start)
	{
		if(start == null)
		{
			return true;
		}
		
		int diff = Math.abs(height1(start.left) - height1(start.right));
		
		if(diff > 1)
		{
			return false;
		}
		else
		{
			return (isBalanced1(start.left) && isBalanced1(start.right));
		}
			
	}
	
	// method II (while calculating the height itself check if there in an unbalanced node and return false if so.)
	public static int height2(node start)
	{
		// base case
		if(start == null)
			return 0;
		
		// check left tree
		int left = height2(start.left);
		if(left == -1)
		{
			return -1;
		}
		
		// check right tree
		int right = height2(start.right);
		if(right == -1)
		{
			return -1;
		}
		
		int diff = Math.abs(left - right);
		
		if(diff == -1)
		{
			return -1;
		}
		else
		{
			return 1 + Math.max(left,right); 
		}
					
	}
	
	public static boolean isBalanced2(node start)
	{
		if(height2(start) == -1)
		{
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		node head = new node(7);
		node firstLeft = new node(5);
		node firstRight = new node(9);
		node second1Left = new node(3);
		node second1Right = new node(6);
		node second2Left = new node(8);
		node second2Right = new node(11);
		node thirdLeft = new node(2);
		node thirdRight = new node(4);

		// Tree creation (Balanced tree)
		head.left = firstLeft;
		head.right = firstRight;
		firstLeft.left = second1Left;
		firstLeft.right = second1Right;
		firstRight.left = second2Left;
		firstRight.right = second2Right;
		second1Left.left = thirdLeft;
		second1Left.right = thirdRight;
		second2Right.right = new node(12);
		
		// non - balanced tree
		node testNode = new node(5);
		testNode.left = firstLeft;
		firstLeft.left = second1Left;
		
		System.out.println("Method 1 : Positive Test : " +isBalanced1(head));
		System.out.println("Method 1 : Negative Test : " +isBalanced1(testNode));
		System.out.println("Method 2 : Positive Test : " +isBalanced1(head));
		System.out.println("Method 2 : Negative Test : " +isBalanced1(testNode));
		
	}
}
