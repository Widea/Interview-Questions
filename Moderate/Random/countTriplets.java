import java.util.Arrays;

/*
 * Count the number of triplets from a given set of numbers that are lesser than a given value. 
 * Reference: http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 */

public class countTriplets {
	int count (int[] A, int sum) {
		if(A == null || A.length <= 2)
			return 0;
		Arrays.sort(A);
		int n = A.length; 
		int output = 0;
		for(int i = 0 ; i < n-2; i++) {
			int j = i+1;
			int k = n-1;
			while(j < k) {
				if(A[i] + A[j] +A[k] >= sum)
					k--;
				else {
					output += (k-j);
					j++;
				}
			}
		}
		return output;
	}
	
	public static void main(String[] a) {
		countTriplets test = new countTriplets();
		int[] input = {23, 12, 33, 67, 54, 1, -45, 101};
		System.out.println(test.count(input, -25));
	}
}
