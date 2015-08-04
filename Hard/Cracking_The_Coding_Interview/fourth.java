package Hard;

/*
 * Cracking the coding interview 
 * Chapter: Hard
 * Solution: 18.4
 * Write a method to count the number of 2s between 0 and n.
 * Author: Viveka Aggarwal
 */

public class fourth {
	
	// A non - optimal solution.
	static int countTwoA(int input) {
		int count = 0;
		for(int i = 2; i <= input ; i++) {
			count += count2(i);
		}
		return count;
	}
	
	static int count2(int num) {
		int count = 0;
		while(num > 0) {
			int rem = num %10;
			num = num/10;
			if(rem == 2)
				count++;
		}
		return count;
	}
	
	// An optimal solution
	static int countTwoB(int input) {
		int count = 0;
		int len = String.valueOf(input).length();
		for(int i = 0; i < len ; i++) {
			count += count2(input, i);
		}
		return count;
	}
	
	static int count2(int num, int d) {
		int count = 0; 
		int pow10 = (int) Math.pow(10, d);
		int nextPow10 = pow10 * 10;
		int right = num % pow10;
		
		int roundDown = num - num % nextPow10;
		int roundUp = roundDown + nextPow10;
		
		int digit = (num/pow10) % 10;
		
		if(digit < 2)
			count = roundDown / 10;
		else if(digit == 2)
			count = (roundDown / 10) + right + 1 ;
		else
			count = roundUp / 10;
		
		return count;
	}
	public static void main(String[] args) {
		int input = 235622;
		System.out.println("Method A: " +countTwoA(input));
		System.out.println("Method B: " +countTwoB(input));
	}
}