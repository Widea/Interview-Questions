import java.util.Scanner;

// Question: Program to implement the 'atoi' function as present in c/c++.
// Definition: It converts a string input to it's integer equivalent.

public class AtoiFunction {
	
	static int atoi(String input) {
		boolean positive = true;
		if(input.charAt(0) == '-')
			positive = false;
		input = input.replaceAll("\\D", "");
		int result = 0;
		for(int i = 0 ; i < input.length() ; i++) {
			result = (result * 10) + (input.charAt(i) - '0');
			if(result >= Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if(result <= Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		
		if(!positive)
			return -result;
		
		return result;
	}
	
	public static void main(String[] a) {
	 Scanner in = new Scanner(System.in);	
	 System.out.println("Enter the string value(number): ");
	 String input = in.nextLine();
	 in.close();
	 System.out.println("The integer equivalent of "+input+" is: "+atoi(input));
	}
}
