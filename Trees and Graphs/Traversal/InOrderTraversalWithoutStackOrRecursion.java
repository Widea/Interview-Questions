// Program to perform in order traversal in java without using a stack or recursion in a BST. 
// Implementation of Morris Traversal.

public class InOrderTraversalWithoutStackOrRecursion {
	static class node {
		int data;
		node left,right;
		
		node(int data) {
			this.data = data;
		}
	}
	
	static void addToTree(node start, int data) {
		if(start == null) {
			start = new node(data);
			return;
		}
		
		node temp = start;
		while(true) {
			if(temp.data >= data) {
				if(temp.left == null) {
					temp.left = new node(data);
					return;
				}
				temp = temp.left;
			} else {
				if(temp.right == null) {
					temp.right = new node(data);
					return;
				}
				temp = temp.right;	
			}
		}
	}
	
	static void inOrderTraversal(node start) {
		if(start == null) {
			System.out.println("Empty BST");
			return;
		}
		
		node current = start, pre;
		
		while(current != null) {
			if(current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				pre = current.left;
				while(pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				
				if(pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				}
			}
		}
	}
	
	public static void main(String[] a) {
		node root = new node(5);
		addToTree(root, 1);
		addToTree(root, 3);
		addToTree(root, 89);
		addToTree(root, 43);
		addToTree(root, 43);
		addToTree(root, 67);
		
		inOrderTraversal(root);
	}
}
