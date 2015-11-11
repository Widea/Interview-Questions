import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/*
 * Author: Viveka Aggarwal
 * Question Statement: Lets say a word has alphabet-consecutive letters if it contains two or more letters which
 * are next to each other in the alphabet. For instance, the word 'task' contains 's' and 't'.
 * Write a program which can find the sentence in a paragraph which has the most words with alphabet-consecutive letters.
 *
*/

public class Solution {

	/*
	 * Function to check if a word has alphabet-consecutive letters.
	 * Input : Word string to be checked.
	 * Output: boolean (True or false depicting if the word would be counted or not)
	 */
	boolean checkWord(String word) {
		HashMap<Character, Boolean> map = new HashMap<>();

		// Put all the characters of the input word in a map.
		for(int i = 0 ; i < word.length() - 1 ; i++) {
			 if(!map.containsKey(word.charAt(i))) {
				 map.put(word.charAt(i), true);
			 }
		}
		// Look for the nearest alphabet of the input character.
		for(int i = 0 ; i < word.length() - 1 ; i++) {

			// Checking for edge case -> if character is z, and word contains a,(and vice-versa) return true!
			if((word.charAt(i) == 'z' && map.containsKey('a')) || (word.charAt(i) == 'a' && map.containsKey('z'))) {
				return true;
			}
            
			if(map.containsKey((char)(word.charAt(i) + 1)) || map.containsKey((char)(word.charAt(i) - 1))) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Function to return the sentence which has the most words with alphabet-consecutive letters.
	 * Input: An ArrayList containing different sentences.
	 * Output: String with max. words with alphabet-consecutive letters.
	 * handles: case where the list is empty, there is only one sentence in the list.
	 */
    
	String getLargestSentenceWithAlphabetConsecutiveLetters(ArrayList<String> input) {
		if(input == null || input.isEmpty())
			return "Empty File";

		// If file has only one sentence return that.
		if(input.size() == 1)
			return input.get(0);

		int maxCount = 0, currentCount; String out = "";
		for(String s : input) {
			currentCount = 0;
			String[] temp = s.split(" ");
			if(temp.length > maxCount) {
				for(String word : temp) {
					if(checkWord(word.toLowerCase().replaceAll("[^a-z]", "")))
						currentCount++;
				}
			}
			if(currentCount > maxCount) {
				maxCount = currentCount;
				out = s;
			}
		}
		return out;
		}

	public static void main(String[] a) {
		Solution s = new Solution();

		// For Example/test purpose
		String file = "TEST FILE PATH GOES HERE";
		Scanner inFile = null;
		try {
			inFile = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder("");
		ArrayList<String> list = new ArrayList<>();

		while(inFile.hasNext()) {
		    sb.append(inFile.nextLine());
		}
		inFile.close();

		String paragraph = sb.toString();
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		iterator.setText(paragraph);

		int start = iterator.first();
		for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
		  list.add(paragraph.substring(start,end));
		}
		String output = s.getLargestSentenceWithAlphabetConsecutiveLetters(list);
		System.out.println(output);
	}
}
