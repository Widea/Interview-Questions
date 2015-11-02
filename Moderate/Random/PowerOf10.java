// Program to check if a given number is power of 10

public class PowerOf10 {
	static String isPowerOf10(int n) {
		if (StrictMath.log10(n)%1 == 0 && n >1) 
			return "Power of 10" ;
		else 
			return "Not power of 10";
	}
	
	public static void main(String[] args) {
		System.out.println("5000 is " +isPowerOf10(5000));
		System.out.println("10000000 is "+isPowerOf10(10000000));
	}
}
