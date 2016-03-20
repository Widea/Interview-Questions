// Source: Glassdoor
// Question: Multiply two very long numbers given as strings and print the result. Each number is at most 1000 digits.

public class FindSum {
	public static void getSum(String one, String two) {
		int[] sum = new int[one.length() + two.length()];
		
		for(int i = one.length() - 1 ; i >= 0 ; i--) {
			int carry = 0;
			for(int j = two.length() - 1 ; j >= 0 ; j--) {
				sum[i + j + 1] += carry + (Character.getNumericValue(one.charAt(i)) * Character.getNumericValue(two.charAt(j)));
				carry = sum[i + j + 1]/10;
				sum[i + j + 1] %= 10;
			}
			sum[i] = carry;
		}
		
		printSum(sum);
	}
	
	public static void printSum(int[] sum) {
		StringBuilder sb = new StringBuilder("");
		for(int i : sum) {
			sb.append(i);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] a) {
		getSum("999999","99999");
	}
}
