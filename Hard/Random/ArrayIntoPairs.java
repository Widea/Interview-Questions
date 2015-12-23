import java.util.HashMap;

/* Question : Check if an array can be divided into pairs whose sum is divisible by k
 * Reference: http://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
 */

public class ArrayIntoPairs {
	static boolean canArrayBeDividedIntoPairs(int[] input, int k) {
		if(input == null || input.length == 0)
			return false;
		
		int len = input.length;
		
		// If the number of elements in the array is odd, return false
		if((len & 1) == 1)
			return false;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// Add the remainders and their respective counts into a hash map. 
		for(int i : input) {
			int r = i % k;		
			if(map.containsKey(r)) {
				int val = map.get(r);
				map.put(r, val+1);
			} else
				map.put(r, 1);	
		}
		
		// Go through the input list and check for possible pairs.
		// Case 1: if the remainder divides k exactly into half, check if the number of occurrences is even.
		// Case 2: if not the above case, then check if k-remainder exists in map, if not return false, 
		//		   if it exists, check if the number of occurrences is equal to that of k-remainder.
		
		
		for(int i : input) {
			int r = i % k;
				int temp = map.get(r);
			if(r * 2 == k || r == 0) {
				if((temp & 1) == 1)
					return false;
			} else {			
				Integer temp2 = map.get(k - r);
				if(temp2 == null || (temp != map.get(k - r)))
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] a) {
		System.out.println(canArrayBeDividedIntoPairs(new int[]{5, 5, 5, 6, 7, 5}, 5));
	}
}
