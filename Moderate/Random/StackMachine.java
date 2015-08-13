import java.util.Stack;

/* Author : Viveka Aggarwal
 * QUESTION: Stack Machine
 * * A stack machine is a simple system that performs arithmetic operations
 * on an input string of numbers and operators. It contains a stack that
 * can store an arbitrary number of 12-bit unsigned integers. Initially the
 * stack is empty. The machine processes a string of characters in the
 * following way:
 * - the characters of the string are processed one by one;
 * - if the current character is a digit ('0'-'9'), the machine
 * pushes the value of that digit onto its stack;
 * - if the current character is '+', the machine pops the two
 * topmost values from its stack, adds them and pushes the result
 * onto the stack;
 * - if the current character is '*', the machine pops the two
 * topmost values from its stack, multiplies them and pushes the
 * result onto the stack;
 * - after the machine has processed the whole string it returns the
 * topmost value of its stack as the result;
 * - the machine reports an error if any operation it performs
 * (addition or multiplication) results in an overflow;
 * - the machine reports an error if it tries to pop an element from
 * its stack when the stack is empty, or if the stack is empty
 * after the machine has processed the whole string.
 *
 * For example, given the string "13+62*7+*" the machine will perform the
 * following operations:
 *
 *  character | comment                | stack
 * -----------------------------------------------
 *            |                        | [empty]
 * '1'        | push 1 onto the stack  |
 *            |                        | 1
 * '3'        | push 3 onto the stack  |
 *            |                        | 1, 3
 * '+'        | perform addition       |
 *            |                        | 4
 * '6'        | push 6 onto the stack  |
 *            |                        | 4, 6
 * '2'        | push 2 onto the stack  |
 *            |                        | 4, 6, 2
 * '*'        | perform multiplication |
 *            |                        | 4, 12
 * '7'        | push 7 onto the stack  |
 *            |                        | 4, 12, 7
 * '+'        | perform addition       |
 *            |                        | 4, 19
 * '*'        | perform multiplication |
 *            |                        | 76
 * The machine will return 76 as the result as it is the top-most element of
 * its stack.
 */

public class StackMachine {
	
	public static String machine(String input) {
		if(input == null)
			return "Error - empty input";
		Stack<Integer> buffer = new Stack<>(); 
		for(int i = 0 ; i < input.length() ; i++) {
			Character c = input.charAt(i);
			if(c >= '0' && c <= '9') {
				buffer.push(c - '0');
			} else if(c.equals('+') || c.equals('*')) {
				Integer a, b, res;
				if(!buffer.isEmpty()) 
					a = buffer.pop();
				else 
					return "Error - empty stack";
				if(!buffer.isEmpty())
					b = buffer.pop();
				else 
					return "Error - empty stack";
				
				if (c.equals('+'))
					res = a + b;
				else
					res = a * b;
				if(res < 4096) {
					buffer.push(res);
				} else
					return "Error - overflow";	
			}
		}
		if(!buffer.isEmpty())
			return String.valueOf(buffer.pop());
		else return "Error - empty stack";
	}
	
	public static void main(String[] a) {
		System.out.println(machine("13+62*7+*"));
	}
}
