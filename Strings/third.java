import java.util.Arrays;
import java.util.Scanner;

// Check if one string is the permutation of the other

class third{
	
static boolean isPermutation(String in1, String in2)
{
	char[] a = in1.toCharArray(); char[] b = in2.toCharArray();
	Arrays.sort(a);
	Arrays.sort(b);
	String a1 = new String(a); String b1 = new String(b);
	return a1.equals(b1);
}

public static void main(String[] args){	
String input1, input2;
Scanner scanner = new Scanner(System.in); 
System.out.println("Enter the first String: ");
input1 = scanner.nextLine();
System.out.println("Enter the second String: ");
input2 = scanner.nextLine();
System.out.println("Permutation check: " +isPermutation(input1,input2));
scanner.close();
}	
	
}
