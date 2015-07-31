package sortingAndSearching;
/*
 * Cracking the coding interview 
 * Chapter: Sorting and Searching
 * Solution: 11.6
 * Given an M X N matrix in which each row and each column is sorted in ascending
 * order, write a method to find an element.
 * Author: Viveka Aggarwal
 */

public class sixth {
	
	static void findElement(int[][] mat, int x) {
		int M = mat.length;
		int N = mat[0].length;
		
		if(x < mat[0][0] || x > mat[M-1][N-1]) {
			System.out.println("Element "+x +" is not in the list");
			return;
		}
		int r = 0, c = N-1;		
		while(r < M && c >= 0) {
			if(mat[r][c] == x) {
				System.out.println("Element "+x+" found at position "+r+" : " +c+".");
				return;
			} else if(mat[r][c] > x) {
				c-- ;
			} else {
				r++;
			}				
		}
	}
	
	static void printMatrix(int[][] mat) {
		for(int i = 0; i < mat.length ; i++) {
			System.out.println();
			for(int j = 0 ; j < mat[i].length ; j++) {
				System.out.print(mat[i][j] + "  ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int M = 5;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}
		
		printMatrix(matrix);		
		findElement(matrix, -1);
		findElement(matrix, 45);
		findElement(matrix, 4);
		findElement(matrix, 23);
	
	}
}