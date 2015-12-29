/*
 * Souce: Geeksforgeeks
 * Find zeroes to be flipped so that number of consecutive 1’s is maximized.
 * Examples:
 * Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1} , m = 2
 * Output:  5 7
 * We are allowed to flip maximum 2 zeroes. If we flip
 * arr[5] and arr[7], we get 8 consecutive 1's which is
 * maximum possible under given constraints 
 */

public class LongestString {
	static void findZeros (int[] arr, int m) {
		if(arr == null || m < 0) {
			System.out.println("Invalid arguments");
			return;
		}
		
		int lW = 0, rW = 0, zero_count = 0, best_count = 0, best_zero_index = 0;
		int len = arr.length;
		
		while(rW < len) {
			if(zero_count <= m) {
				if(arr[rW] == 0)
					zero_count++;
				rW++;
			}
		
			if(zero_count > m) {
				if(arr[lW] == 0) 
					zero_count--;
				lW++;
			}
			
			if(rW - lW > best_count) {
				best_count = rW- lW;
				best_zero_index = lW;
			}
		}
		
		for (int i=0; i< best_count; i++)
	    {
	        if (arr[best_zero_index+i] == 0)
	           System.out.println(best_zero_index+i + " ");
	    }
	}
	
	public static void main(String[] a) {
		findZeros(new int[] {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}, 2);
		
	}
}
