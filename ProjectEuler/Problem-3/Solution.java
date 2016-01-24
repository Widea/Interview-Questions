/* 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

public class Solution {
	static long largestPrimeFactor(long n) {
		while(true) {
			long p = getFactor(n);
			if(p < n) {
				n = n/p;
			} else
				return n;
		}
	}
	
	static long getFactor(long n) {
		for(long i = 2 ; i <= n/2 ; i++) {
			if(n % i == 0)
				return i;
		}
		return n;
	}
	
	public static void main(String[] a) {
		long max = 600851475143L;
		System.out.println(largestPrimeFactor(max));
	}
}
