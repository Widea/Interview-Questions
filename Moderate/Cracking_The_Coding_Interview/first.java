package moderate;

/*
 * Cracking the coding interview 
 * Chapter: Moderate
 * Solution: 17.1
 * Write a function to swap a number in place(that is, without temporary variables).
 * Author: Viveka Aggarwal
 */

public class first {
	
	public static void swap1(int a, int b) {
		a = a + b; 
		b = a - b;
		a = a - b;
		
		System.out.println(a + " " + b);
	}
	
	public static void swap2(int a, int b) {
		a = a ^ b; // a xor b
		b = a ^ b; // a xor b xor b
		a = a ^ b; // a xor b xor a 
		
		System.out.println(a + " " + b);
	} 
	
	public static void main(String[] args) {
		int x = 6;
		int y = 5;
		swap1(x,y);
		swap2(x,y);
	}
}
