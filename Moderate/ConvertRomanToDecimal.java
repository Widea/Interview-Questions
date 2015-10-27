// Program to convert a roman numeral string to it's decimal equivalent.
import java.util.HashMap;

public class ConvertRomanToDecimal {
	static int convert(String roman) {
		if(roman == null || roman.length() == 0)
			return 0;
		
		HashMap<Character, Integer> romanValue = new HashMap<>();
		romanValue.put('I', 1);
		romanValue.put('V', 5);
		romanValue.put('X', 10);
		romanValue.put('L', 50);
		romanValue.put('C', 100);
		romanValue.put('D', 500);
		romanValue.put('M', 100);
		
		int output = 0;
		int prev = 0;
		
		for(int i = roman.length()-1 ; i >= 0 ; i--) {
			int temp = romanValue.get(roman.charAt(i));
			if(temp < prev)
				output-=temp;
			else
				output+=temp;
			prev = temp;
		}
		return output;
	}
	
	public static void main(String[] a) {
		System.out.println("Decimal value of XVIII is: " +convert("XVIII"));
	}
}
