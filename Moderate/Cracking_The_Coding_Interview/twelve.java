package moderate;

import java.util.Arrays;

/*
 * Cracking the coding interview 
 * Chapter: Moderate
 * Solution: 17.12
 * Design an algorithm to find all pairs of integers within an array which sum to a specified value.
 * Author: Viveka Aggarwal
 */

public class twelve {
	static void getPairs(int[] a, int sum) {
		int i = 0, j = a.length - 1;
		
		while(i < j) {
			int s = a[i] + a[j];
			if(s == sum) {
				System.out.println("Pair -> " +a[i] + " : " +a[j]);
				i++; j--;
			}
			if(s < sum)
				i++;
			else
				j--;				
		}
	}
	
	public static void main(String[] args) {
		int[] input = {-10, -2, -1, 0, 3, 5, 5, 6, 7, 9, 13, 14, 21};
		int sum = 11;
		Arrays.sort(input);
		getPairs(input, sum);
	}
}