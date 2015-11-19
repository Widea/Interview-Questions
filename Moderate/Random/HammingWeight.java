// Program to calculate the number of 1s in the binary representation of a number.

public class HammingWeight {
	
	static int getOnes(int input) {
		int count = 0;
		while(input != 0) {
			input &= (input-1);
			count++;
		}
		return count;
	}
	
	public static void main(String[] a) {
		int input = 11;
		System.out.println("The hamming weight of " +input+" is: "+getOnes(input));
	}
}
