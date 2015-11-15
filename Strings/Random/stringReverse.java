import java.util.Scanner;
import java.util.Stack;

class stringReverse{
	
	static String reverseString(String input)
	{
		Stack tempBuffer = new Stack();
		for(int i = 0; i < input.length(); i++)
			tempBuffer.add(input.charAt(i));
		StringBuffer temp = new StringBuffer("");
		while(!tempBuffer.isEmpty())
		  temp.append(tempBuffer.pop());
		return temp.toString();
	}
	
	public static void main(String[] args){
		String inputString;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string: ");
		inputString = in.nextLine();	
		System.out.println("The reversed string is: " + reverseString(inputString));
	}
}
