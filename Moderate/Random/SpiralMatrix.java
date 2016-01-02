public class SpiralMatrix {
	
	static void printSpiralOrder(int[][] arr) {
		if(arr == null || arr.length == 0)
			return;
		int m = arr.length, n = arr[0].length, max_layers = m/2, layer = 0;
		if((m == n && m % 2 == 0) || (m < n))
			max_layers = m/2;
		else max_layers++;
			
			
		while(layer < max_layers) {
			// Prints top row
			for(int i = layer ; i <= n - 1 - layer ; i++) {
				System.out.print(arr[layer][i] + "   ");
			}

			// Prints right column
			for(int j = layer + 1 ; j < m - 1 - layer ; j++) {
				System.out.print(arr[j][n - 1 - layer] + "   ");
			}

			// Prints bottom row
			for(int i = n - layer - 1 ; i > layer ; i--) {
				System.out.print(arr[m - layer - 1][i] + "   ");
			}

			// Prints left column
			for(int j = m - layer - 1 ; j > layer ; j--) {
				System.out.print(arr[j][layer] + "   ");
			}
			layer++;
		}
	}
	
	public static void main(String[] a) {
		printSpiralOrder(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}});
		System.out.println();
		printSpiralOrder(new int[][] {{1,2}, {3, 4}});
		System.out.println();
		printSpiralOrder(new int[][] {{1,2,3}, {4,5,6}});
		System.out.println();
		printSpiralOrder(new int[][] {{1,2},{3, 4},{5,6}});
		System.out.println();
	}

}
