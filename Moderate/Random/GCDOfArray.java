// Program to find the GCD of an array of integers 

public class GCDOfArray {
	static int GCD(int a, int b) {
		if(a == 0 || b == 0)
			return 0;
		
		if(a == b)
			return a;
		
		int r;
		while((r = a % b) != 0) {
			a = b ; 
			b = r;
		}
		
		return b;
	}
	
	public static void main(String[] args) {
		int[] input = {160, 112, 180, 240, 288, 32, 480, 96, 60, 72};
		
		int gcd = input[0];
		
		for(int i = 1; i < input.length; i++)
			gcd = GCD(gcd, input[i]);
		System.out.println(gcd);
	}
}
