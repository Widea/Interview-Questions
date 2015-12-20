import java.util.ArrayList;
import java.util.Scanner;

/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.6
 * Implement an algorithm to print all valid (i.e. properly opened and closed) 
 * combinations of n-pairs of parentheses.
 */

public class sixth {
	
	void getValidParanthesis(ArrayList<String> list, char[] curr, int right, int left, int index) {
		if(left < 0 || left > right) {
			return;
		}
		
		if(left == 0 && right == 0) {
			String temp = String.copyValueOf(curr);
			list.add(temp);
		}
		
		if(left > 0) {
			curr[index] = '(';
			getValidParanthesis(list, curr, right, left-1, index+1);
		}
		
		if(right > left) {
			curr[index] = ')';
			getValidParanthesis(list, curr, right-1, left, index+1);
		}	
	}
	
	ArrayList<String> getValidParanthesis(int n) {
		char[] curr = new char[n*2];
		ArrayList<String> list = new ArrayList<String>();
		getValidParanthesis(list, curr, n, n, 0);
		return list;
	}
	
	public static void main(String[] a) {
		sixth test = new sixth();
		int n = 3;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		ArrayList<String> list = test.getValidParanthesis(n);
		System.out.println(list);
	}
}
