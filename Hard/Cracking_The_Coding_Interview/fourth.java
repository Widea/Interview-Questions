package Hard;

/*
 * Cracking the coding interview 
 * Chapter: Hard
 * Solution: 18.4
 * Write a method to count the number of 2s between 0 and n.
 * Author: Viveka Aggarwal
 */

public class fourth {
	
	// A non - optimal solution.
	static int countTwoA(int input) {
		int count = 0;
		for(int i = 2; i < input ; i++) {
			count += count2(i);
		}
		return count;
	}
	
	static int count2(int num) {
		int count = 0;
		while(num > 0) {
			int rem = num %10;
			num = num/10;
			if(rem == 2)
				count++;
		}
		return count;
	}
	
	// An optimal solution
	static int countTwoB(int input) {
		return 0;
	}
	public static void main(String[] args) {
		int input = 235627;
		System.out.println("Method A: " +countTwoA(input));
		System.out.println("Method B: " +countTwoB(input));
	}
}