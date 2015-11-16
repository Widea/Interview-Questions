/*
 *  Cracking the coding interview 
 * Chapter: Arrays and Strings
 * Solution: 1.6
 * Question: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * author: Viveka Aggarwal
 */

public class sixth {
	void print(int[][] input) {
		for(int i = 0 ; i < input.length ; i++) {
			System.out.println();
			for(int j = 0 ; j < input[i].length ; j++) {
				System.out.print(input[i][j] + " ");
			}
		}
		System.out.println();
	}
	
	void rotateMatrix(int[][] input, int n) {
		int layers = n/2 - 1;
		
		for(int layer = 0 ; layer <= layers ; layer++) {
			int start = layer;
			int end = (n - 1) - layer;
			
			for(int i = start; i < end ; i++ ) {
				int offset = i - start;
				int top = input[start][i];
				
				// left to top -> bottom to left -> right to bottom -> top to right			
				input[start][i] = input[end - offset][start];
				input[end - offset][start] = input[end][end - offset];
				input[end][end - offset] = input[i][end];
				input[i][end] = top;
			}
		}
	}
	
	public static void main(String[] a) {
		sixth solution = new sixth();
		int[][] input_matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int length = input_matrix.length;
		solution.print(input_matrix);
		solution.rotateMatrix(input_matrix, length);
		solution.print(input_matrix);
	}
}
