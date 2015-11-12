import java.util.ArrayList;
import java.util.Scanner;

// Program to find the first n prime numbers based on sieve of erastosthenes.

public class FirstNPrimes {
	static void printFirstNPrimes(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		boolean isPrime;
		
		for(int i = 8 ; n > primes.size() ; i++) {
			isPrime = true;
			for(int prime : primes) {
				if(i % prime == 0) {
					isPrime = false;
					break;
				}	
			}
			if(isPrime)
				primes.add(i);
		}
		
		for(int prime : primes)
			System.out.println(prime);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the n value: ");
		int limit = in.nextInt();
		in.close();
		printFirstNPrimes(limit);
	}
}
