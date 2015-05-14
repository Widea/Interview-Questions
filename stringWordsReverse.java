import java.util.Scanner;
import java.util.Stack;

// program to reverse the words in a string

class StringWordsReverse
{
	static void reverseWords(String input)
	{		
		StringBuffer Reverse = new StringBuffer("");
		String[] arr = input.split(" ");
		for(int i = arr.length - 1; i >= 0 ; i-- )
		{
			Reverse.append(arr[i]).append(" ");
		}			
		System.out.println(Reverse);		
	}
		
	public static void main(String[] args){	
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string to be reversed: ");
		String inputString = in.nextLine();
		reverseWords(inputString);
	}	
}
