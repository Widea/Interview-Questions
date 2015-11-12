// program to convert a sorted array into a balanced binary search tree!

public class SortedArrayToBST {
	static class node {
		node left,right;
		int data;
		
		node(int data) {
			this.data = data;
		}
	}
	
	node convertArrayToBST(int[] input) {
		return convertArrayToBST(input, 0, input.length-1);
	}
	
	node convertArrayToBST(int[] input, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end)/2;
		node root = new node(input[mid]);
		
		root.left = convertArrayToBST(input, start, mid-1);
		root.right = convertArrayToBST(input, mid+1, end);
		
		return root;
	}
	

	String toString(node start) {
		if(start == null) {
			return "";
		}
		return toString(start.left) + " " + start.data + " " + toString(start.right);
	}
	
	public static void main(String[] a) {
		SortedArrayToBST s = new SortedArrayToBST();
		int arr[] = {2,5,7,8,10,33,56,87,98};
		node root = s.convertArrayToBST(arr);
		System.out.println(s.toString(root));
	}
}
