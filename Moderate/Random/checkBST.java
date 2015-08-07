public class checkBST {
	public static class node {
		int data;
		node left;
		node right;
		
		node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public static node createBST(int option) {
		node root = new node(10);
		node one = new node(8);
		node two = new node(8);
		node three = new node(9);
		node four = new node(15);
		switch (option) {
		case 1: /* Is BST (Only unique elements) */
			root.left = one;
			root.right = four;
			one.left = two;
			one.right = three;
			return root;
		case 2: /* Not BST (Only unique elements) */
			root.right = two;
			root.left = one;
			one.left = four;
			one.right = three;
			return root;
		default: return null;	
		}
	}
	
	public static boolean isBST(node n) {
		return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	static boolean isBST(node n, int min, int max) {
		if(n == null)
			return true;
		
		if(n.data <= min || n.data > max)
			return false;
		
		if(!isBST(n.left, min, n.data) || !isBST(n.right, n.data, max)) 
			return false;
		
		return true;
	}
	
	public static void main(String[] a) {
		node tree = createBST(1);
		System.out.println(isBST(tree));
		tree = createBST(2);
		System.out.println(isBST(tree));
	}
}