/*
 * Program to get the left and right view of a Binary tree.
 * Author: Viveka Aggarwal
 */

public class BinarySearchTreeViews {
	Node root;
	Level l;
	public class Node {
		Node left;
		Node right;
		Integer data;
		
		Node() {
		}
		
		Node(Integer data) {
			left = right = null;
			this.data = data;
		}
	}
	
	class Level {
		int max_level;
		
		Level() {
		}
	}
	
	void getLeftView() {
		getLeftView(root);
	}
	
	void getLeftView(Node r) {
		int level = 1;
		
		l.max_level = 0;
		
		getLeftView(r, level, l.max_level);
	}
	
	void getLeftView(Node n, int level, int max_level) {
		max_level = l.max_level;
		if(n == null)
			return;
		
		// For the first node
		if(l.max_level < level) {
			System.out.print(n.data + " ");
			l.max_level = level;
		}
		
		getLeftView(n.left, level+1, l.max_level);
		getLeftView(n.right, level+1, l.max_level);	
	}
	
	
	void getRightView() {
		getRightView(root);
	}
	
	void getRightView(Node r) {
		int level = 1;
		
		l.max_level = 0;
		
		getRightView(r, level, l.max_level);
	}
	
	void getRightView(Node n, int level, int max_level) {
		max_level = l.max_level;
		if(n == null)
			return;
		
		// For the first node
		if(l.max_level < level) {
			System.out.print(n.data + " ");
			l.max_level = level;
		}

		getRightView(n.right, level+1, l.max_level);	
		getRightView(n.left, level+1, l.max_level);
	}
	
	
	
	BinarySearchTreeViews() {
		root = new Node();
		l = new Level();
	}
	
	BinarySearchTreeViews(Integer data) {
		root = new Node(data);
		l = new Level();
	}
	
	public void addToTree(Integer data) {
		addToTree(root, data);
	}
	
	private void addToTree(Node curr, Integer data) {
		if(curr == null) {
			curr = new Node(data);
		} else if(curr.data.compareTo(data) >= 0) {
			if(curr.left == null)
				curr.left = new Node(data);
			else
				addToTree(curr.left, data);
		} else {
			if(curr.right == null)
				curr.right = new Node(data);
			else
				addToTree(curr.right, data);
		}
	}
	
	public int getHeight(Node start) {
		if(start == null)
			return 0;
		
		return 1 + Math.max(getHeight(start.left), getHeight(start.right));
	}
	
	@Override
	public String toString() {
		return toString(this.root);
	}
	
	String toString(Node curr) {
		if(curr == null)
			return "";
		return toString(curr.left) + " " + curr.data + " " + toString(curr.right);
	}
	
	int diameter(Node curr) {
		if(curr == null) 
			return 0;
		
		int dia_root = getHeight(curr.left) + getHeight(curr.right) + 1;
		int dia_left = diameter(curr.left);
		int dia_right = diameter(curr.right);
		
		return Math.max(dia_root, Math.max(dia_left, dia_right));
	}
	
	public static void main(String[] args) {
		BinarySearchTreeViews tree = new BinarySearchTreeViews(12);
		tree.addToTree(10);
		tree.addToTree(25);
		tree.addToTree(30);
		tree.addToTree(40);

		System.out.println(tree.toString());
		System.out.println(tree.diameter(tree.root));
		tree.getLeftView();
	}
}
