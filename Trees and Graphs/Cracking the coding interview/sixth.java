/*
 * Write an algorithm to find the'next'node (i.e., in-order successor) of a given node in a binary search tree. 
 * You may assume that each node has a link to its parent.
 */
public class sixth{

	public static class node
	{
		node left;
		node right;
		node parent;
		Object data;
		
		node(Object data, node parent)
		{
			this.data = data;
			this.parent = parent;
		}		
	}
	
	public static node findNext(node input)
	{
		if(input == null)
		{
			return null;
		}
		
		// if node has a right tree, return the left most element of that tree
		if(input.right != null)
		{
			return leftMostNode(input.right);
		}
		
		// if node doesn't have a right tree, move up till node becomes left node
		// node a = input;
		node p = input.parent;
		
		while(p != null && p.left != input)
		{
			input = input.parent;
			p = input.parent;
		}
		
		return input;		
	}
	
	public static node leftMostNode(node in)
	{
		if(in == null)
		{
			return null;
		}
		
		while(in.left != null)
		{
			in = in.left;
		}	
		
		return in;
	}
		
	public static void main(String[] args)
	{
		node head = new node(7, null);
		node firstLeft = new node(5, head);
		node firstRight = new node(9, head);
		node second1Left = new node(3, firstLeft);
		node second1Right = new node(6, firstLeft);
		node second2Left = new node(8, firstRight);
		node second2Right = new node(11, firstRight);
		node thirdLeft = new node(2, second1Left);
		node thirdRight = new node(4, second1Left);
		node lastNode =new node(12, second2Right);
		
		// Tree creation
		head.left = firstLeft;
		head.right = firstRight;
		firstLeft.left = second1Left;
		firstLeft.right = second1Right;
		firstRight.left = second2Left;
		firstRight.right = second2Right;
		second1Left.left = thirdLeft;
		second1Left.right = thirdRight;
		second2Right.right = lastNode;
					
		node temp = findNext(head);
		
		System.out.println(temp.data);
	}
}
