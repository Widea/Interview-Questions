import java.util.Arrays;

// Program to implement the Sieve of Eratosthenes.
// The sieve helps finding all possible prime numbers upto a given limit.

public class Sieve_of_Eratosthenes {
	void getPrimes(int limit) {
		boolean[] isPrime = new boolean[limit+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		int limitRoot = (int)Math.sqrt(limit);
		int i;
		for(i = 0 ; i <= limitRoot ; i++) {
			if(isPrime[i]) {
				System.out.print(i + " ");
				for(int j = i*i ; j <= limit ; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		while(i <= limit) {
			if(isPrime[i]) {
				System.out.print(i + " ");
			}
			i++;
		}
	}
	
	public static void main(String[] a) {
		Sieve_of_Eratosthenes s = new Sieve_of_Eratosthenes();
		s.getPrimes(100);
	}
}
