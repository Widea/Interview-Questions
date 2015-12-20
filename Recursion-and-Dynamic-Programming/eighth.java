import java.util.ArrayList;

/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.8
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) 
 * and pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */

public class eighth {
	int numberOfWays(int n) {
		if(n <= 0)
			return 0;
		
		return numberOfWays(n, 25);
	}
	
	int numberOfWays(int n, int denom) {
		int next_denom = 0;
		
		switch(denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		
		int ways = 0;
		
		for(int i = 0; i * denom <= n; i++) {
			ways += numberOfWays(n - (i * denom) , next_denom);
		}
		
		return ways;
	}
	
	public static void main(String[] a) {
		eighth test = new eighth();
		System.out.println(test.numberOfWays(247));
	}
}
