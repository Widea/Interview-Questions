/*
 * Cracking the coding interview 
 * Chapter: Arrays and Strings
 * Write a method to replace all spaces in a string with'%20'. You may assume that
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if implementing 
 * in Java, please use a character array so that you can perform this operation
 * in place.)
 * EXAMPLE
 * Input: "Mr John Smith
 * Output: "Mr%20Dohn%20Smith"
 * author: Viveka Aggarwal
 */


public class fourth {
	
	
	static String replaceSpaces(char[] in, int len) {
		
		int spaceCount = 0;
		
		for(int i = 0; i < len ; i++) {
			if(in[i] == ' ' &&  in[i] != '\0')
				spaceCount++;				
		}
		
		int newLen = spaceCount*2 + len;
		
		for(int i1 = len - 1 ; i1 >= 0  ; i1--) {
			if(in[i1] == ' ') {
				in[newLen - 1] = '0';
				in[newLen - 2] = '2';
				in[newLen - 3] = '%';
				newLen-=3;
			} else {
				in[newLen - 1] = in[i1];
				newLen = newLen - 1;
			}			
		}
		
		return String.valueOf(in);
	}	
		
	public static void main(String[] args) {
		char[] input = {'H','e','l','l','o',' ',' ','i',' ','V',' ','\0','\0','\0','\0','\0','\0','\0','\0','\0'};
		int length = 11;
		System.out.println("Input string: " + String.valueOf(input));
		String output1 = replaceSpaces(input, length);
		System.out.println("Output string: " +output1);
	}
}
