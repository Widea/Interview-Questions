// Question: Find the GCD of the given array of integers.

public class GCD {
	
	static int getGCD(int[] arr) {
		if(arr == null || arr.length == 0) {
			System.out.println("Emoty array");
			return Integer.MIN_VALUE;
		}
		
		if(arr.length == 1) {
			return arr[0];
		}
		
		int gcd = arr[0];
		
		for(int i = 1 ; i < arr.length ; i++) {
			
			gcd = getGCD(gcd, arr[i]);
			System.out.println(gcd);
		}
		
		return gcd;
	}
	
	 static int getGCD(int a, int b) {
		
		 if(a == 0 || b == 0)
			 return 0;
		 
		 if(a == b)
			return a;
		 
		 int r;
		while((r = a % b) != 0) {
			 a = b;
			 b = r;
		 }
		
		 return b;
	 }
	
	public static void main(String[] a) {
		int[] input = {22, 66, 52, 98, 58, 62, 115, 11};
		System.out.println("GCD of the input array is: " +getGCD(input));
	}
}
