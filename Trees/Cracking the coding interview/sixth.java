public class sixth{

	public class node
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

	}
}
