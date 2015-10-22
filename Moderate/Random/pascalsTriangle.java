import java.util.Scanner;

// program to print a pascal's triangle

public class pascalsTriangle {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of levels for the pascal's triangle: ");
		int levels = in.nextInt();
		in.close();
		System.out.println();
		
		// Creating the pascal's triangle
			int[][] pascal = new int[levels][]; 
			for(int i = 0 ; i < levels ; i++) {
				pascal[i] = new int[i+2];
				for(int j = 0 ; j <= i; j++) {
					if(j == 0 || j == i)
						pascal[i][j] = 1;
					else 
						pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
				}
			}
		
		// Printing the pascal's triangle
		for(int i = 0 ; i < levels ; i++) {
			for(int k = 0 ; k < levels-i ; k++) {
				System.out.print(" ");
			}
			for(int j = 0; j <= i ; j++) {
				System.out.print(pascal[i][j]+" ");
			}
			System.out.println();
		}
	}
}
