import java.util.HashMap;

// Source: Glassdoor
// Question: Given an array where all numbers except one are repeated. Find the number that only occurs once.

public class FindNonRepeatedNumber {
	
	// If all the numbers are repeated only once, except one.
	public static int findNonRepeatedNumberWithDoubles(int[] input) {
		if(input == null || input.length == 0) {		
			System.out.println("Error!!! Empty Array");
			return Integer.MIN_VALUE;
		}
		
		int sum = input[0];		
		for(int i = 1; i < input.length ; i++) {
			sum ^= input[i]; 
		}
		
		return sum;
	}
	
	// If we do not have information for how often the numbers are repeated
	public static int findNonRepeatedNumber(int[] input) {
		if(input == null || input.length == 0) {		
			System.out.println("Error!!! Empty Array");
			return Integer.MIN_VALUE;
		}
		
		if(input.length == 1) {
			return input[0];
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : input) {
			if(map.containsKey(i)) {
				int current_count = map.get(i);
				map.put(i, current_count+1);
			} else {
				map.put(i, 1);
			}
		}
		
		for(int i : map.keySet()) {
			if(map.get(i) == 1) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
		
	}
	
	public static void main(String[] a) {
		System.out.println(findNonRepeatedNumberWithDoubles(new int[] {1,2,3,5,1,3,5,6,6,8,2}));
		System.out.println(findNonRepeatedNumber(new int[] {1,2,3,3,3,5,1,3,5,6,6,8,8,7,8,9,9,2,2,2,2,2}));
	}
}
