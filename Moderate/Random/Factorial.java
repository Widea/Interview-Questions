/*
 * Factorial of any number n is defined as the multiplication of numbers from one to the given number.
 * Concept: Dynamic Programming
 */

public class Factorial {
	public static long factor(int n) {
		long[] factorTable = new long[n+1];
		for(int i = 0 ; i <= n ; i++) {
			if(i == 0 || i == 1)
				factorTable[i] = 1;
			else
				factorTable[i] = factorTable[i-1] * i;
		}
		return factorTable[n];
	} 
	public static void main(String[] a) {
		System.out.println(factor(20));
	}
}
