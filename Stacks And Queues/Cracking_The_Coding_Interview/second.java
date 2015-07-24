import java.util.Stack;
/*
 * Cracking the coding interview 
 * Chapter: Stacks and Queues
 * Solution: 3.2
 * How would you design a stack which, in addition to push and pop, also has a
 * function min which returns the minimum element? Push, pop and min should all
 * operate in 0(1) time.
 * Author: Viveka Aggarwal
 */

public class second extends Stack<Integer> {
	Stack<Integer> minStack;
	Stack<Integer> maxStack;
	
	public second() {
		minStack = new Stack<Integer>();
		maxStack = new Stack<Integer>();
	}
	
	public Integer pop() {
		if(super.isEmpty())
			return -9999999;
		
		int temp = super.pop();
		
		if(min() == temp)
			minStack.pop();
		
		if(max() == temp)
			maxStack.pop();
		
		return temp;
	}
	
	public void push(int item) {
		super.push(item);
		
		if(min() >= item)
			minStack.push(item);
		
		if(max() <= item)
			maxStack.push(item);
	}
	
	public int min() {
		if(minStack.isEmpty())
			return 9999999;
		return minStack.peek();
	}
	
	public int max() {
		if(maxStack.isEmpty())
			return -9999999;
		return maxStack.peek();
	}
	
	public static void main(String[] args) {
		second stack = new second();		
		stack.push(1);
		stack.push(8);
		stack.push(5);
		stack.push(4);
		stack.push(9);
		stack.push(23);
		stack.push(-1);
		stack.push(2);
		stack.push(-1);
		/* OUTPUT */
		System.out.println("Current min: " +stack.min());
		System.out.println("Current max: " +stack.max());
		stack.pop();
		System.out.println("After popping one element");
		System.out.println("Current min: " +stack.min());
		System.out.println("Current max: " +stack.max());
		stack.pop();stack.pop();stack.pop();stack.pop();
		System.out.println("After popping four more elements");
		System.out.println("Current min: " +stack.min());
		System.out.println("Current max: " +stack.max());
	}
}