// Program to rotate a given BST, also to print the elements at any given level

public class treeRotation {	
	static class node {
		node left; 
		node right;
		int data;
		
		node(int data) {
			this.data = data;
		}	
	}
	
	static void add(node start, int data) {
		if(start == null) {
			start = new node(data);
			return;
		}
		
		node temp = start;
		while(true) {			
			if(temp.data >= data) {
				if(temp.left == null)
				{
					temp.left = new node(data);
					return;
				}
				temp = temp.left;
			}
			else {
				if(temp.right == null)
				{
					temp.right = new node(data);
					return;
				}
				temp = temp.right;
			}
		}	
	}
	
	static String printTree(node start) {
		if(start == null)
			return "";
		return start.data + " " +printTree(start.left) + " " + printTree(start.right);
	}
	
	static void PrintLevelK(node start, int k) {
		if(start == null) {
			System.out.print("null ");
			return;
		}
		
		if(k == 0){
			System.out.print(start.data + " ");
			return;
		}
		
		PrintLevelK(start.left, k-1);
		PrintLevelK(start.right, k-1);			
	}
	
	static node leftRotation(node start) {
		node newRoot = start.right;
		start.right = newRoot.left;
		newRoot.left = start;
		return newRoot;
	}
	
	static node rightRotation(node start) {
		node newRoot = start.left;
		start.left = newRoot.right;
		newRoot.right = start;
		return newRoot;
	}
	
	public static void main(String[] a) {
		node root = new node(5);
		add(root, 17);
		add(root, 1);
		add(root, 3);
		add(root, 23);
		add(root, 2);
		add(root, 15);
		add(root, 8);
		add(root, 4);
		
		System.out.println(printTree(root));
		
		PrintLevelK(root, 0);
		System.out.println();
		PrintLevelK(root, 1);
		System.out.println();
		PrintLevelK(root, 2);
		System.out.println();
		PrintLevelK(root, 3);
		System.out.println(); 
		
		root = leftRotation(root);
		System.out.println(printTree(root));
		root = rightRotation(root);
		System.out.println(printTree(root));
		root = rightRotation(root);
		System.out.println(printTree(root));

	}
}
