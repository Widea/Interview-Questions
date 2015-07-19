import java.util.Scanner;

/* Cracking the coding interview
 * Chapter : Arrays and Strings
 * Question: 1.7
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * Author : Viveka Aggarwal
 */

public class seven {
	
	public static void zeroMatrix (int[][] input) {
		
		boolean[] r = new boolean[input.length];
		boolean[] c = new boolean[input[0].length];
				
		for(int i = 0; i < input.length ; i++) {
			for(int j = 0; j < input[0].length ; j++) {
				if(input[i][j] == 0) {
					r[i] = true;
					c[j] = true;
				}					
			}
		}
		
		for(int i = 0; i < input.length ; i++) {
			for(int j = 0; j < input[i].length ; j++) {
				if(r[i] == true || c[j] == true) {
					input[i][j] = 0;
				}					
			}
		}
		
		printMat(input);
	}
	
	public static void printMat(int[][] input) {
		
		for(int i = 0; i < input.length ; i++) {
			System.out.println();
			for(int j = 0; j < input[i].length ; j++) {
				System.out.print(input[i][j] + " ");
				}
			}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter row dimensions: ");
		int r = in.nextInt();
		System.out.println("Enter column dimensions: ");
		int c = in.nextInt();
				
		int[][] inputMat = new int[r][c];
		
		for(int i = 0 ; i < r ; i++) {
			System.out.println("Enter values for row " +(i+1) + ": ");
			for(int j = 0 ; j < c ; j++) {
				inputMat[i][j] = in.nextInt();
			}
		}		
		int[][] inpMat = new int[][]{{1,0,3,4},{5,6,7,4},{2,10,11,2}};
		zeroMatrix(inputMat);
		zeroMatrix(inpMat);
	}
}