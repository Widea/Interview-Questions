// Program to find the longest possible palindrome in a given string
// One method could be the brute force method: Where you find every possible substring
// of a given string and check if it is a palindrome and return the longest. (Not optimal)
// Reference : http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/

public class LongestPalindrome {
	static String getLongestPalindrome(String input) {
			if(input.length() == 0 ||input.length() == 1)
			return input;
		
			String longest = input.substring(0, 1);
		
			for(int i = 0 ; i < input.length() ; i++) {
				String tmp = helper(input, i, i);
				if (tmp.length() > longest.length()) {
					longest = tmp;
				}
	 
				tmp = helper(input, i, i + 1);
				if (tmp.length() > longest.length()) {
					longest = tmp;
				}
			}
			return longest;
		}
	
	static String helper(String input, int start, int end) {
		while (start >= 0 && end <= input.length() - 1 && input.charAt(start) == input.charAt(end) ) {
			start--;
			end++;
		}
		return input.substring(start + 1, end);
	}
	
	public static void main(String[] a) {
		System.out.println(getLongestPalindrome(" trean at a tanama"));
	}
}
