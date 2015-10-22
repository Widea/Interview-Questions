// program to implement a stack using templates

public class stack<E> {
	private int size;
	private int topIndex;
	private E[] stackArray;
	
	stack() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	stack(int size) {
		this.size = size > 0 ? size : 10;
		topIndex = -1;
		stackArray = (E[]) new Object[size];
	}
	
	public int size() {
		return topIndex+1;
	}
	
	public boolean isEmpty() {
		if(topIndex == -1) {
			return true;
		}
		
		return false;
	} 
	
	public boolean isFull() {
		if(size == size()) {
			return true;
		}
		
		return false;
	} 
	
	public E peek() {
		if(isEmpty()) {
			System.out.println("Empty stack!!!");
			return null;
		}
		
		return stackArray[topIndex];
	}
	
	public E pop() {
		if(isEmpty()) {
			System.out.println("Empty stack!!!");
			return null;
		}
		topIndex--;
		return stackArray[topIndex];
	}
	
	public void push(E inputValue) {
		if(!isFull()) {
			stackArray[++topIndex] = inputValue;
		}
		else
			System.out.println("The stack is full, try popping a few elements before adding new ones.");
	}
	
	public static void main(String[] args) {
		stack<Integer> sI = new stack<>();
		for(int i = 1 ; i <= 11 ; i++) {
			sI.push((Integer)i);	
			System.out.println(sI.peek());
		}	
	}
}
