// Program to find the least common ancestor of two given nodes in a BST

public class LeastCommonAncestor {
	static class node {
		int data;
		node left;
		node right;
		
		node(int data) {
			this.data = data;
			left = right = null;
		}
		
		node(int data, node left, node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	public static node findAncestor(node start, int l, int r) {
		if(start == null) {
			return null;
		}
		while(start != null) {
			if(l < start.data && r < start.data) {
				start = start.left;
			}
			if(l > start.data && r > start.data) {
				start = start.right;
			}
			break;
		}
		return start;
	}
		
	public static void main(String[] a) {
		node root = new node(5, new node(3, new node(1), new node(4)), new node (8, new node(7), new node(9)));
		node ancestor = findAncestor(root,7, 9);
		if(ancestor != null)
			System.out.println(ancestor.data);
		else 
			System.out.println("No common ancestor or empty tree");
		
	}
}
