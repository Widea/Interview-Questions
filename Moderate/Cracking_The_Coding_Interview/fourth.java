package moderate;
/*
 * Cracking the coding interview 
 * Chapter: Sorting and Searching
 * Solution: 17.4
 * Write a method which finds the maximum of two numbers. 
 * You should not use if-else or any other comparison operator.
 * Author: Viveka Aggarwal
 */

public class fourth {
	public static int flip(int a) {
		return (a ^ 1);
	}
	
	public static int getSign(int a) {
		return flip((a >> 31) & 0x1);
	}
	
	public static int getMax(int a, int b) {
		int sign_a = getSign(a);
		int sign_b = getSign(b);
		int sign_ab = getSign(a-b);
		
		int sa = sign_a ^ sign_b;
		int sab = flip(sa);
		int k = (sa * sign_a) + (sab * sign_ab);
		int flip_k = flip(k); 
		return k * a + flip_k * b;
		
	}
	
	public static void main(String[] args) {
		System.out.println(getMax(-15, 2));
		System.out.println(getMax(2099999999, -999999999));
		System.out.println(getMax(45, 54));
	}
}