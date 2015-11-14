// Program to check if a given string is a palindrome or not. 

public class Palindrome {
	static boolean isPalindrome(String input) {
		if(input.isEmpty())
			return true;
		
		for(int i = 0, j = input.length()-1 ; j >= i ; i++, j--) {
			if(input.charAt(i) != input.charAt(j))
				return false;
		}
		return true;
	}
	
	public static void main(String[] a) {
		System.out.println(isPalindrome("Hello"));
		System.out.println(isPalindrome("HelileH"));
		System.out.println(isPalindrome("ABCCBA"));
	}
}
