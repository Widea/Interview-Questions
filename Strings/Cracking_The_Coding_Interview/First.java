import java.util.HashMap;
import java.util.Scanner;

// check if a string has all unique characters

class First{
	static boolean isUnique(String input)
	{	
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < input.length(); i++){
			if(map.containsKey(input.charAt(i)))
				return false;
			else
				map.put(input.charAt(i), 1);
		}	
		return true;
	}
	
	public static void main(String[] args)
	{
		String inputString;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string:");
		inputString = in.nextLine();
		System.out.println("Uniqueness: " +isUnique(inputString));
		in.close();
	}	
}
