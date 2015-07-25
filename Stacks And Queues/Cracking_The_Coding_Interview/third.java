import java.util.ArrayList;
import java.util.Stack;

/*
 * Cracking the coding interview 
 * Chapter: Stacks and Queues
 * Solution: 3.3
 * Imagine a (literal) stack of plates. If the stack gets too high, 
 * it might topple. Therefore, in real life, we would likely start 
 * a new stack when the previous stack exceeds some threshold. 
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks and should 
 * create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks. pop () should behave 
 * identically to a single stack (that is, pop () should return 
 * the same values as it would if there were just a single stack).
 * FOLLOW UP:
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 * Author: Viveka Aggarwal
 */

public class third {
	static class SetOfStacks {
		ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
		int capacity;
		
		SetOfStacks(int capacity) {
			this.capacity = capacity;
		}
		
		public Stack getLastStack() {
			if(stacks.size() == 0)
				return null;
			return stacks.get(stacks.size() - 1);
		}
		
		public boolean isFull(Stack in){
			return (in.size() >= capacity);
		}
		
		public void push(int data) {
			Stack end = getLastStack();
			if( end != null && !isFull(end) ) {
				end.push(data);
			} else {
				Stack in = new Stack();
				in.push(data);
				stacks.add(in);
			}
		}
		
		public boolean isEmpty() {
			if(getLastStack() == null && stacks.size() == 0)
				return true;
			return false;
		}
		
		public Integer peek() {
			if(stacks.isEmpty())
				return null;
			return stacks.get(stacks.size() - 1).peek();
		}
		
		public Integer pop() {
			if(stacks.isEmpty())
				return null;
			else {
				Stack<Integer> end = getLastStack();
				int out = end.pop();
				if (end.size() == 0) 	
					stacks.remove(stacks.size() - 1);
				return out;
			}
		}
		
		public static void main(String[] args) {
			SetOfStacks set = new SetOfStacks(2);
			set.push(1);
			set.push(2);
			set.push(3);
			set.push(4);
			set.push(5);
			
			System.out.println("Current stack peek: " +set.peek());
			System.out.println("Is stack empty? "+set.isEmpty());
			System.out.println("Popping stack top: " +set.pop());
			System.out.println("Current stack peek: " +set.peek());
		
		}
	}
}
