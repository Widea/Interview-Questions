// Program to print all possible prime numbers from 1 to n.

public class PrimeNumbers {
	static String getPrime (int n) {
		
		if(n <= 1)
			return "No primes";
		
		String out = "";
		
		boolean isPrime = true;
		
		for(int i = 2 ; i <= n ; i++) {
			isPrime = true;
			for(int j = 2 ; j <= i/2 ; j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime)
				out += i + " ";
		}
		return out;
	}
	
	public static void main(String[] a) {
		System.out.println(getPrime(100));
		// 1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
	}
}
