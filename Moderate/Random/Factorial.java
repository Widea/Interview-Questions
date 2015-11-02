/*
 * Factorial of any number n is defined as the multiplication of numbers from one to the given number.
 */

public class Factorial {
	public static long factor(int n) {
		long out = 1;
		for(int i = 2 ; i <= n ; i++) {
			out *= i;
		}
		return out;
	} 
	public static void main(String[] a) {
		System.out.println(factor(20)); //2432902008176640000
	}
}
