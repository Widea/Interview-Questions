 package sortingAndSearching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * Cracking the coding interview 
 * Chapter: Sorting and Searching
 * Solution: 11.2
 * Write a method to sort an array of strings so that all the anagrams are next to each other. 
 * Author: Viveka Aggarwal
 */

 public class second {
	 
	 public static void sort(String[] a) {
		Map<String,LinkedList<String>> anagramMap = new HashMap<String, LinkedList<String>>();
		 for(String i : a) {
			char[] temp = i.toCharArray();
			Arrays.sort(temp);
			String key = new String(temp);
			
			if(! anagramMap.containsKey(key)) {
				anagramMap.put(key, new LinkedList<String>());
			}
			
			LinkedList l = anagramMap.get(key);
			l.add(i);
		}
		 
		int index = 0; 
		for(String i : anagramMap.keySet()) {
			LinkedList<String> temp = anagramMap.get(i);
			for(String t : temp) {
				a[index] = t;
				index++;
			}
		} 
	 }
	 
	 public static void printArray(String[] a) {
		 System.out.println("Printing array: ");
		 for(String i : a) {
			 System.out.print(i + " ");
		 }
	 }
	 
	 public static void main(String[] args) {
			String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
			sort(array);
			printArray(array);
		}
 }

