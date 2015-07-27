import java.util.Scanner;

/* Cracking the coding interview
 * Chapter : Trees and Graphs
 * Question: 4.3
 * Given a sorted (increasing order) array with unique integer elements, 
 * write an algorithm to create a binary search tree with minimal height.
 * Author : Viveka Aggarwal
 */

public class third {
	static class node {
		int data;
		node left;
		node right;
		
		node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	static node createBST(int[] input) {
		return createBST(input, 0 , input.length - 1);
	}
	
	static node createBST(int[] input, int start, int end) {
		if(end < start)
			return null;
		
		int mid = (start + end) / 2;
		
		node output = new node(input[mid]);
		output.left = createBST(input, start, mid - 1);
		output.right = createBST(input, mid+1, end);
		
		return output;
	}
	
	static int getHeight(node root) {
		if(root == null)
			return 0;
		
		return 1 + Math.min(getHeight(root.left), getHeight(root.right));
	}

	public static void main(String[] a) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array length: ");
		int length = in.nextInt();
		int[] inputArr = new int[length];
		System.out.println("Enter array values: ");
		for(int i = 0 ; i < length ; i++)
			inputArr[i] = in.nextInt();
		
		node root = createBST(inputArr);
		System.out.println(getHeight(root));
		
		in.close();
		
	}
}
