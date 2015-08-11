import java.util.Scanner;

/* 
 * CareerCup Interview Question - Google
 * Question -> 
 * Find how many numbers of length n are there such that each number is at least 
 * four smaller/greater than the number before and after it. 
 * Example: if n = 5, such numbers are 39518, 15951, etc.
 */

public class findNumbers {
	 final static int[][] state = {
	        {4, 5, 6, 7, 8, 9}, // 0
	        {5, 6, 7, 8, 9},    // 1
	        {6, 7, 8, 9},       // 2
	        {7, 8, 9},          // 3
	        {0, 8, 9},          // 4
	        {0, 1, 9},          // 5
	        {0, 1, 2},          // 6
	        {0, 1, 2, 3},       // 7
	        {0, 1, 2, 3, 4},    // 8
	        {0, 1, 2, 3, 4, 5}, // 9
	    };
	 static int count = 0;
	
	public static void main(String[] a) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter length of numbers you want to search for: ");
		int n = in.nextInt();
		countNumbers("", 0 , n);
		in.close();
	}
	
	public static void countNumbers(String prefix, int start, int l) {
		if(start == 0) {
			for(int i = 1 ; i < 9; i++) {
				countNumbers(prefix + i, start + 1 , l);
			}
		} else if(start == l) {
			System.out.println(prefix);
			count++;
		} else {
			int previous = prefix.charAt(start - 1) - '0';
			for(int i : state[previous]) {
				countNumbers(prefix + i, start + 1, l);
			}
		}		
	}
}