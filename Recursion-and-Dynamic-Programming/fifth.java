import java.util.ArrayList;

/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.5
 * Write a method to compute all permutations of a string.
 */

public class fifth {
	ArrayList<String> getPermutations(String input) {
		ArrayList<String> output = new ArrayList<>();
		if(input == null)
			return null;
		
		// Base case
		if(input.length() == 0) {
			output.add("");
			return output;
		}
		
		char first = input.charAt(0);
		String rest = input.substring(1);
		ArrayList<String> list = new ArrayList<>();
		list = getPermutations(rest);
		
		for(String l : list) {
			for(int i = 0 ; i <= l.length() ; i++) {
				String s = addCharacter(first, l, i);
				output.add(s);
			}
		}
		
		return output;
	}
	
	String addCharacter(char first, String input, int pos) {
		if(input.length() == 0)
			return String.valueOf(first);
		
		String first_half = input.substring(0, pos);
		String second_half = input.substring(pos);
		return first_half+first+second_half;
	}

	public static void main(String[] a) {
		fifth test = new fifth();
		ArrayList<String> permuations = test.getPermutations("Hello");
		System.out.println(permuations.toString());
 	}
	
}
