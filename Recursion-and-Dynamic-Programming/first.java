import java.util.Arrays;

/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.1
 * A child is running up a staircase with n steps, and can hop either 1step, 2 steps, or 3 steps at a time. 
 * Implement a method to count how many possible ways the child can run up the stairs.
 */

public class first {
	int getSteps (int n) {		
		if(n <= 0)
			return 0;
		
		int[] map = new int[n+1];
		Arrays.fill(map, -1);
		return getSteps(n, map);
	}
	
	int getSteps(int n, int[] map) {
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		else if(map[n] > -1)
			return map[n];
		else {
			map[n] = getSteps(n - 1, map) + getSteps(n - 2, map) + getSteps(n - 3, map);
			return map[n];
		}	
	}
	
	public static void main(String[] args) {
		first test = new first();
		System.out.println(test.getSteps(3));
	}
}
