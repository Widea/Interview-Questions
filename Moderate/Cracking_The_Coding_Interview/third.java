package moderate;

/*
 * Cracking the coding interview 
 * Chapter: Moderate
 * Solution: 17.3
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 * Author: Viveka Aggarwal
 */

public class third {
	public static int numOfTrailingZeros(int num) {		
		if(num < 0) {
			num = num * -1;
		}
		
		int count = 0;
		int d = 5;
		
		while(num / d > 0) {
			count += num / d;
			d = d * 5;
		}
		return count;
	} 
	
	public static void main(String[] args) {
		System.out.println("The number of trailing zeros in 24! are: " +numOfTrailingZeros(24));
		System.out.println("The number of trailing zeros in -15! are: " +numOfTrailingZeros(-15));

	}
}
