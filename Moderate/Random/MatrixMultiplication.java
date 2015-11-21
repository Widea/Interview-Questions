// Program to multiply two matrixes and print their output

public class MatrixMultiplication {
	
	static void mulMatrixes(int[][] mat1, int[][] mat2) {		
		if(mat1 == null || mat2 == null) {
			System.out.println("One or both of the matrices are empty!!!");
			return;
		}
		
		int m1 = mat1.length; int n1 = mat1[0].length;
		int m2 = mat2.length; int n2 = mat2[0].length;
		
		if(n1 != m2) {
			System.out.println("Cannot multiply these matrixes!!!");
			return;
		}
		
		System.out.println("Input matrix 1: ");
		printMatrix(mat1);
		System.out.println();
		System.out.println("Input matrix 2: ");
		printMatrix(mat2);
		
		int[][] output = new int[m1][n2];
		
		for(int i = 0 ; i < m1 ; i++) {
			for(int j = 0 ; j < n2 ; j++) {
				for(int k = 0 ; k < n1 ; k++) {
					output[i][j] += (mat1[i][k] * mat2[k][j]); 
				}
			}
		}		
		System.out.println();
		System.out.println("Output matrix: ");
		printMatrix(output);
	}

	static void printMatrix(int[][] input) {
		for(int i = 0 ; i < input.length ; i++) {
			for(int j = 0 ; j < input[i].length ; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] a) {
		int[][] input1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] input2 = {{9,10,11,12},{13,14,15,16},{1,2,3,4},{5,6,7,8}};
		mulMatrixes(input1, input2);
	}
}
