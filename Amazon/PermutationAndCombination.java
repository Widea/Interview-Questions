import java.math.BigInteger;
import java.util.Scanner;

// Program to find the nCr and nPr value of given numbers. 

// Formulae: nPr = n!/(n-r)!
// 			 nCr = n!/(n-r)!r!

public class PermutationAndCombination {
	
	static BigInteger factorial(int n) {
		if(n == 0)
			return BigInteger.ONE;
		
		BigInteger sum = BigInteger.valueOf(n); 
		
		while(n > 1) {
			sum = sum.multiply(BigInteger.valueOf(n - 1));
			n--;
		}
		
		return sum;
	}
	
	public static void main(String[] a) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = in.nextInt();
		System.out.println("Enter r value: ");
		int r = in.nextInt();
		if(r > n) {
			System.out.println("Invalid values");
			return;
		}		
		BigInteger nFac_Div_nRFac = (factorial(n)).divide(factorial(n-r));

		System.out.println("nPr value is: "+nFac_Div_nRFac);
		System.out.println("nCr value is: "+nFac_Div_nRFac.divide(factorial(r)));
	}
}
