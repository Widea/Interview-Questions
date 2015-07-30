package sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Cracking the coding interview 
 * Chapter: Sorting and Searching
 * Solution: 11.7
 * A circus is designing a tower routine consisting of people standing atop one another's
 * shoulders. For practical and aesthetic reasons, each person must be both shorter
 * and lighter than the person below him or her. Given the heights and weights of
 * each person in the circus, write a method to compute the largest possible number
 * of people in such a tower.
 * Author: Viveka Aggarwal
 */

public class seventh {
	
	public static class HtWt implements Comparable {
		private int height;
		private int weight;
		
		HtWt(int height, int weight) {
			this.height = height;
			this.weight = weight;
		}
		
		public int compareTo(Object second) {
			HtWt s = (HtWt)second; 
			if(this.height == s.height)
				return ((Integer)this.weight).compareTo(s.weight);
			else 
				return ((Integer)this.height).compareTo(s.height);
		}
		
		@Override
		public String toString() {
			return (height + " : " + weight);
		}
		
		public boolean isBefore(HtWt second) {
			if(this.height < second.height && this.weight < second.weight)
				return true;
			return false;
		}
	}
	
	private static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
		if (seq1 == null) {
			return seq2;
		} 
		if (seq2 == null) {
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}
	
	public static void longestSubsequence(ArrayList<HtWt> list, ArrayList<HtWt>[] solutions, int index) {
		if (index >= list.size() || index < 0) {
			return;
		}
		HtWt current = list.get(index);
		
		ArrayList<HtWt> best_sequence = null;
		for (int i = 0; i < index; i++) {
			if (list.get(i).isBefore(current)) { 
				best_sequence = seqWithMaxLength(best_sequence, solutions[i]); 
			}
		}
		
		// Append current_element
		ArrayList<HtWt> new_solution = new ArrayList<HtWt>();
		if (best_sequence != null) {
			new_solution.addAll(best_sequence);
		} 
		new_solution.add(current);
		
		// Add to list and recurse
		solutions[index] = new_solution;
		longestSubsequence(list, solutions, index + 1);
	}
	
	public static ArrayList<HtWt> longestSequence(ArrayList<HtWt> list) {
		Collections.sort(list);
		ArrayList<HtWt>[] solutions = new ArrayList[list.size()];
		longestSubsequence(list, solutions, 0);
		ArrayList<HtWt> best_sequence = null;
		
		for (int i = 0; i < list.size(); i++) {
			best_sequence = seqWithMaxLength(best_sequence, solutions[i]);
		}
		
		return best_sequence;
	}
	
	public static void main(String[] args) {
		ArrayList<HtWt> items = new ArrayList<>();
		
		HtWt item = new HtWt(65, 60);
		items.add(item);
		
		item = new HtWt(70, 150);
		items.add(item);
		
		item = new HtWt(56, 90);
		items.add(item);
		
		item = new HtWt(75, 190);
		items.add(item);
		
		item = new HtWt(60, 95);
		items.add(item);
		
		item = new HtWt(68, 110);
		items.add(item);
		
		item = new HtWt(35, 65);
		items.add(item);
		
		item = new HtWt(40, 60);
		items.add(item);
		
		item = new HtWt(45, 63);
		items.add(item);
				
		item = new HtWt(45, 78);
		items.add(item);
		
		ArrayList<HtWt> output = longestSequence(items);

		System.out.println("Printing the largest sequence . . .");
		for(HtWt i : output) {
			System.out.println(i.toString());
		}
	}
	
}