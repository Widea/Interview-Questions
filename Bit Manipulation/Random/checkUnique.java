
// Program to check if a string has all unique characters. 
// Assumption: The string has between a-z characters. No special characters or numericals. 
// We make use of bit manipulation to solve this problem

public class checkUnique {
	boolean isUnique(String input) {
		if(input == null || input.length() > 26)
			return false;
		
		if(input.length() <= 1)
			return true;
		
		int checker = 0;
		for (int i = 0; i < input.length(); i++) {
			int val = input.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] a) {
		checkUnique cu = new checkUnique();
		String[] test = {"hello", "apple", "no", "abcdefghiyz"};
		for(String t : test) {
			System.out.println(cu.isUnique(t));
		}
	}
}
