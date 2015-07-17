import java.util.Scanner;

/* Cracking the coding interview
 * Chapter : Arrays and Strings
 * Question: 1.5
 * Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2blc5a3. 
 * If the "compressed" string would not become smaller than the original string, 
 * your method should return the original string.
 */

public class fifth {
	
	static String compressString(String input) {
		
		if(input.isEmpty()) {
			return null;
		}
		
		StringBuffer output = new StringBuffer("");
		output.append(input.charAt(0));	
		char cur = input.charAt(0);
		int count = 1;
		
		for(int i = 1 ; i < input.length() ; i++) {
			if(input.charAt(i) != cur) {
				cur = input.charAt(i);
				output.append(count);
		    	output.append(cur);
				count = 1;
				} else {
					count++;
				}
			}
		
		output.append(count);
		
		if(output.length() >= input.length())
			return input;
		else
			return output.toString();
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String output = compressString(input);
		System.out.println("Compressed String: "+output);
		in.close();
	}
}
