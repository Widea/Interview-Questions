// Program to reverse a given number

public class ReverseANumber {
	
	static int reverseNumber(int number) {		
		boolean neg = false;
		if(number < 0) {
			number = number * -1;
			neg = true;
		}
		
		if(number <= 9)
			return number;
		
		int out = 0;
		
		while(number > 0) {
			int r = number % 10;
			out = (out * 10) + r;
			number /= 10;
		}
		
		return neg == true ? -out : out;
	}
	
	public static void main( String[] a) {
		System.out.println(reverseNumber(-1221628));
	}
}
