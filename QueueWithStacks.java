/**
* Implementing a queue class using two stacks
* @Author: Viveka Aggarwal
* @Refernce : Chapter 3(Stacks and Queues), Question 5.
* @Book version: Fifth
**/

import java.util.Stack;

public class QueueWithStacks
{	
	Stack stack1,stack2;
	
	// Default constructor
	public QueueWithStacks()
	{
		stack1= new Stack <Integer> ();
		stack2= new Stack <Integer> ();
	} 

	// constructor with call to the super constructor, and adding the input value to the queue.
	public QueueWithStacks(Integer input)
	{
		super();	
		stack1.push(input);
	}

	//add a new value to the queue
	public void enqueue(Integer input)
	{
		stack1.push(input);
	}

	// remove  value from the queue
	public void dequeue()
	{
		if(stack1.isEmpty() && stack2.isEmpty())
			return;
		
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}		
		stack2.pop();
	}

	// check the queue's front node value 
	public Object peekFront()
	{
		if(stack1.isEmpty() && stack2.isEmpty())
		return null;
	
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	// check the queue's rear node value 
	public Object peekRear()
	{
		if(stack1.isEmpty() && stack2.isEmpty())
			return null;
	
		if(stack1.isEmpty()){
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
		}
		return stack1.peek();
	}
	
		
// main function for defining new queue and testing values	
public static void main(String[] args)
{
	QueueWithStacks queue = new QueueWithStacks();
	queue.enqueue(2);
	queue.enqueue(3);
	System.out.println(queue.peekFront());
	System.out.println(queue.peekRear());
	queue.dequeue();
	System.out.println(queue.peekFront());
	System.out.println(queue.peekRear());
}	
}
