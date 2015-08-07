/*
 * Given an integer array, output all pairs that sum up to a specific value k. 
 * Consider the fact that the same number can add up to `k` with its duplicates in the array.
 * For example the array is [1, 1, 2, 3, 4] and the desired sum is 4. 
 * Should we output the pair (1, 3) twice or just once? 
 * Also do we output the reverse of a pair, meaning both (3, 1) and (1, 3)? 
 * Let’s keep the output as short as possible and print each pair only once. 
 * So, we will output only one copy of (1, 3). Also note that we shouldn’t output (2, 2) 
 * because it’s not a pair of two distinct elements.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ArrayPairSum {
/**	 
	* Does not consider duplicates of numbers
	 * 
	 * @param Sum
	 *            . Example: 8
	 * @param Integer
	 *            array. Example: [3, 4, 5, 4, 4]
	 * @return List of Integer pairs. Example: [[3, 5], [4, 4]]. Does not
	 *         consider multiple occurrences of number 4.
	 */

	public static ArrayList<int[]> getPairs(int sum, int[] arr) {
		ArrayList<int[]> output = new ArrayList<>();
		HashMap<Integer, Boolean> checkVal = new HashMap<>();
		
		for(int i = 0 ; i < arr.length; i++) {
			int diff = sum - arr[i];
			if(checkVal.containsKey(diff) && !checkVal.get(diff)) {
				int[] temp = new int[2];
				temp[0] = arr[i];
				temp[1] = diff;
				output.add(temp);
				checkVal.put(arr[i], true);
			}
			else
				checkVal.put(arr[i], false);
		}
		return output;
	}
	
	public static void printList(ArrayList<int[]> in) {
		int count = 1;
		for(int[] arr : in) {
			System.out.println();
			System.out.print("Printing list " +count++ +" : ");
			for(int i : arr) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main(String[] arg) {
		int[] input1 = { 3, 4, 5, 6, 7 };
		printList(getPairs(10, input1));
		System.out.println();
		int[] input2 = { 3, 4, 5, 4, 4 };
		printList(getPairs(8, input2));
	}
	
}
