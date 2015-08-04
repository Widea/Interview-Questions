package Hard;

/*
 * Cracking the coding interview 
 * Chapter: Moderate
 * Solution: 18.1
 * Write a function that adds two numbers. You should not use + or any arithmetic operators.
 * Author: Viveka Aggarwal
 */

public class first {
	public static int add(int a, int b) {
		if(b == 0) 
			return a;
		int S1 = a ^ b; // adding just numbers
		int S2 = (a & b) << 1; // adding just the carry bit
		
		return add(S1,S2);
	}
	
	public static void main(String[] args) {
		int a = 9356;
		int b = 1939;
		
		System.out.println(a + " + " +b +" = " +add(a,b));
		
	}
}