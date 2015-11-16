import java.util.Scanner;

/* Cracking the coding interview
 * Chapter : Strings
 * Question: 1.2
 * Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.
 * Implementing the abve question in java
 * Author : Viveka Aggarwal
 */

public class second {
	
	// Iterative approach
	static String reverse1(String input) {
		if(input.length() == 0 || input.length() == 1)
			return input;
		
		StringBuilder output = new StringBuilder("");
		for(int i = input.length() - 1 ; i >= 0 ; i--) {
			output.append(input.charAt(i));
		}
		return output.toString();
	}
	
	// Recursive approach
	static String reverse2(String input) {
		if(input.length() == 0 || input.length() == 1)
			return input;
		
		return reverse2(input.substring(1)) + input.charAt(0);
	}
	
	public static void main(String args[]) {
		System.out.println("Enter the string to be reversed: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		System.out.println("1. Reversed String using iteration: " +reverse1(input));
		System.out.println("2. Reversed String using recursion: " +reverse2(input));
	}
	
}
