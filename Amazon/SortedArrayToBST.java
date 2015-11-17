import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Question: Convert the given sorted array into a minimum height BST, and print it in level-order and in-order format.

public class SortedArrayToBST {
	static class node {
		node left,right;
		int data;
		
		node(int data) {
			this.data = data;
		}
	}
	
	node convertToBST(int[] arr) {
		if(arr == null)
			return null;
		
		return convertToBST(arr, 0, arr.length-1);
	}
	
	node convertToBST(int[] arr, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start+end)/2;
		
		node root = new node(arr[mid]);
		root.left = convertToBST(arr, start, mid-1);
		root.right = convertToBST(arr, mid+1, end);
		
		return root;
	}
	
	void printTree(node start) {
		if(start == null) {
			System.out.println("Empty Tree");
			return;
		}
		Queue<node> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			node curr = q.poll();
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
			
			System.out.print(curr.data + " ");
		}
	}
	
	void printTreeInOrder(node start) {
		if(start == null) {
			return;
		}
		printTreeInOrder(start.left);
		System.out.print(start.data + " ");
		printTreeInOrder(start.right);
		
	}
	
	public static void main(String[] a) {
		SortedArrayToBST s = new SortedArrayToBST();
		int[] arr = {1, 4, 7, 9, 13, 26, 67, 89};
		node root = s.convertToBST(arr);
		System.out.print("Printing in level order: ");
		s.printTree(root);
		System.out.println();
		System.out.print("Printing in inorder: ");
		s.printTreeInOrder(root);
	}
}
