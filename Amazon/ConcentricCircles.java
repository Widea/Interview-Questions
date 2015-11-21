// Program to rotate a given 2-D matrix in concentric circles.
// That each layer is rotated in the opposite direction of its previous layer. 

public class ConcentricCircles {
	
	static void rotateMatrix(int[][] input) {
		int m = input.length ; int n = input[0].length;
		int layers = 0;
		System.out.println("n: "+n + " : " +"m: "+m);
		System.out.println("Initial matrix: ");
		print(input);

		while (layers < n/2) {			
			if(layers % 2 == 0)
				clockwise(layers, m, n, input);
			else 
				antiClockwise(layers, m, n, input);
			
			layers++;
		}
			
		System.out.println("Rotated Matrix: ");
		print(input);
	}
	
	// Traversing in clockwise order starting from top(right to left)
	static void clockwise(int layers, int m, int n, int[][] input) {
		int temp = input[layers][layers];
		
		// Top layer
		for(int j = layers+1 ; j < n - layers ; j++) {
			int t = input[layers][j];
			input[layers][j] = temp;
			temp = t;
		}
					
		// Right layer
		for(int i = layers+1; i < m - layers ; i++) {
			int t = input[i][n-layers-1];
			input[i][n-layers-1] = temp;
			temp = t;
		}
					
		// Down layer
		for(int j = n-2-layers ; j >= layers; j--) {
			int t = input[m-1-layers][j];
			input[m-1-layers][j] = temp;
			temp = t;
		}	
		
		// Left layer
		for(int i = m - 2- layers ; i >= layers ; i--) {
			int t = input[i][layers];
			input[i][layers] = temp;
			temp = t;
		}
	}
	
	// Traversing in anti-clockwise order starting from left corner most element going down.
	static void antiClockwise(int layers, int m, int n, int[][] input) {
		int temp = input[layers][layers];
		
		// Left layer
	    for(int i = layers+1 ; i < m - layers ; i++) {
	    	int t = input[i][layers];
			input[i][layers] = temp;
			temp = t;
		}
				
		// Down layer
		for(int j = layers+1 ; j < n - layers; j++) {
			int t = input[m-1-layers][j];
			input[m-1-layers][j] = temp;
			temp = t;
		}	
				
		// Right layer
		for(int i = m-2-layers; i >= layers ; i--) {
			int t = input[i][n-layers-1];
			input[i][n-layers-1] = temp;
			temp = t;
		}		
		
		// Top layer
		for(int j = n - 2- layers ; j >= layers ; j--) {
			int t = input[layers][j];
			input[layers][j] = temp;
			temp = t;
		}
	}
	
	static void print(int[][] input) {
		for(int i = 0 ; i < input.length ; i++) {
			for(int j = 0 ; j < input[i].length ; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] a) {
		int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotateMatrix(input);
	}
}
