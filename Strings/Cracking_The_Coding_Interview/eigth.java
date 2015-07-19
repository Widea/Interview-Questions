import java.util.Scanner;

/* Cracking the coding interview
 * Chapter : Arrays and Strings
 * Question: 1.8
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check If s2 is a rotation of s1 
 * using only one call to isSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
 * Author : Viveka Aggarwal
 */

public class eigth {
	
	public static boolean isRotation(String actual, String rotation) {
	if(actual == null && rotation == null)
            return true;
        if(actual.length() != rotation.length())
            return false;
        String temp = rotation + rotation;
		if(isSubstring(actual, temp)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isSubstring(String check, String inp) {
		return inp.contains(check);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the actual string: ");
		String s1 = in.nextLine();
		System.out.println("enter the rotated string: ");
		String s2 = in.nextLine();		
		System.out.println("Checking if string 2 is the rotation of string 1 . . . ");
		System.out.println(isRotation(s1,s2));
		in.close();
	}
}
