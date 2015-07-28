import java.util.Stack;

/*
 * Cracking the coding interview 
 * Chapter: Stacks and Queues
 * Solution: 3.5
 * Implement a MyQueue class which implements a queue using two stacks.
 * Author: Viveka Aggarwal
 */

public class fifth {
	private Stack<Integer> stackOld;
	private Stack<Integer> stackNew;
	
	public fifth() {
		stackOld = new Stack<Integer>();
		stackNew = new Stack<Integer>();
	}
	
	public void shiftStacks() {
		if(stackOld.isEmpty()) {
			while(!stackNew.isEmpty())
				stackOld.push(stackNew.pop());
		}
	}
	
	public int size() {
		return (stackNew.size() + stackOld.size());
	}
	
	public void enqueue(int data) {
		stackNew.push(data);
	}
	
	
	public Integer peek() {
		shiftStacks();
		if(stackOld.isEmpty())
			return null;
		else 
			return stackOld.peek(); 
	}
	
	public Integer dequeue() {
		shiftStacks();
		if(stackOld.isEmpty())
			return null;
		else 
			return stackOld.pop();
	}
	
	public static void main(String[] args) {
		fifth queue = new fifth();
		fifth queue1 = new fifth();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		
		System.out.println("Peek function: " +queue.peek());
		System.out.println("Pop function: " +queue.dequeue());
		
	}
}