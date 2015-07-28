import java.util.Stack;

/*
 * Cracking the coding interview 
 * Chapter: Stacks and Queues
 * Solution: 3.6
 * Write a program to sort a stack in ascending order (with biggest items on top). 
 * You may use at most one additional stack to hold items, but you may not copy the 
 * elements into any other data structure (such as an array). The stack supports the 
 * following operations: push, pop, peek, and isEmpty.
 * Author: Viveka Aggarwal
 */

public class sixth {
	
	public static Stack<Integer> sortStack(Stack<Integer> input) {
		if(input == null)
			return null;
		Stack<Integer> output = new Stack<Integer>();
		while(!input.isEmpty()) {
			int temp = input.pop();
			while(!output.isEmpty() && output.peek() > temp)
				input.push(output.pop());
			output.push(temp);
		}
		return output;
	}

	public static void main(String[] args) {
		Stack<Integer> input = new Stack<>();
		input.push(12);
		input.push(5);
		input.push(8);
		input.push(7);
		input.push(33);
		input.push(3);
		input.push(9);
		
		Stack<Integer> output = sortStack(input);
		
		while(!output.isEmpty()) {
			System.out.println(output.pop());
		}
	}
}

