package sortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Cracking the coding interview 
 * Chapter: Sorting and Searching
 * Solution: 11.2
 * Write a method to sort an array of strings so that all the anagrams are next to each other. 
 * Author: Viveka Aggarwal
 */

// Solution to problem second, using comparator method

public class anagramSort implements Comparator<String> {
	
	private String sort(String a) {
		char[] temp = a.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}
	
	public int compare(String a, String b) {
		return sort(a).compareTo(sort(b));
	}
	
	 public static void printArray(String[] a) {
		 System.out.println("Printing array: ");
		 for(String i : a) {
			 System.out.print(i + " ");
		 }
	 }

	 public static void main(String[] args) {
			String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
			Arrays.sort(array, new anagramSort());
			printArray(array);
		}
}

