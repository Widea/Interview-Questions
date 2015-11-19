import java.util.ArrayList;
import java.util.Arrays;

// Reference: http://www.programcreek.com/2013/01/leetcode-subsets-java/

// Program to create a set of all possible subsets of a given set!
// For example: For a given set S = {1,2,3}
// The solution should be: {}, {1}, {2}, {3}, {1,2}, {1,3}, {2, 3}, {1, 2, 3}

public class SetOfSubsets {
	static ArrayList<ArrayList<Integer>> subSets(int[] input) {
		if(input.length == 0)
			return null;
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();	
		for(int i = 0 ; i < input.length ; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();	
			
			for(ArrayList<Integer> r : result) {
				temp.add(new ArrayList<>(r));
			}
			
			for(ArrayList<Integer> a : temp) {
				a.add(input[i]);
			}
			
			ArrayList<Integer> single = new ArrayList<>();
			single.add(input[i]);
			temp.add(single);
			
			result.addAll(temp);
		}
		
		// Adding the empty list
		result.add(new ArrayList<>());
		return result;
	}
	
	public static void main(String[] a) {
		int[] input = {23, 45, 12};
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = subSets(input);
		for(ArrayList<Integer> r : result ) {
			System.out.println(r.toString());
		}
	}
	}
