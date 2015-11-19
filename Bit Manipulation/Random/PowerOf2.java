// Program to check if a given number is a power of two
public class PowerOf2 {
	static boolean isPowerOf2(int input) {
		if(input <= 0)
			return false;

		return ((input & (input - 1)) == 0);
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf2(10));
		System.out.println(isPowerOf2(-16));
		System.out.println(isPowerOf2(1));
		System.out.println(isPowerOf2(128));
		System.out.println(isPowerOf2(27));
	}
}
