package moderate;

/*
 * Cracking the coding interview 
 * Chapter: Moderate
 * Solution: 17.8
 * You are given an array of integers (both positive and negative). 
 * Find the contiguous sequence with the largest sum. Return the sum.
 * Author: Viveka Aggarwal
 */

public class eighth {
	static int getLargestSum(int[] a) {
		int maxSum = 0, sum = 0;
		
		for(int i : a) {
			sum += i;
			if(maxSum < sum)
				maxSum = sum;
			if(sum < 0)
				sum = 0;
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] test =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(+getLargestSum(test));
	}
}