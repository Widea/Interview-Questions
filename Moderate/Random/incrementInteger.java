/*
 * CareerCup Interview Question - Google
 * You are given an array representing integer. Write a function which increments this integer. 
 * Example: input [1,2,3] (represents 123) -> output [1,2,4]
 * Author: Viveka Aggarwal
 */
public class incrementInteger {
	public static void main(String[] a) {
		int[] in = {9,9,9};
		increment(in);
		for(int i : in) {
			System.out.print(i + " ");
		}
	}
	
	static void increment(int[] x) {
		int start = x[0];
		int i = x.length - 1, j;
		for (; i>=0 ; i-- ) {
			j = x[i];
			if(j < 9) {
				x[i] = j + 1;
				break;
			} else {
				x[i] = 0;
			}
		}
		
		if(x[0] == 0 && start == 9) {
			System.out.println("Errrooorrr!!! Exceeded buffer space!!!");
			throw new IllegalArgumentException();
		}
		
	}
}
