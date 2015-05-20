// a stack data structure that gives the minimum and maximum value in O(1) time. 

import java.util.Scanner;
import java.util.Stack;

public class StackWithMinMax extends Stack<Integer> {
	
	private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    // default constructor to initialize the min and max stacks.
    public StackWithMinMax() 
    {
        minStack = new Stack<Integer>();    
        maxStack = new Stack<Integer>();    
    }
    
    // function to attain the maximum value
    public int getMax()
    {
    	if(minStack.isEmpty())
    	{	
    		return -999999999;
    	}	
    	return maxStack.peek();
    }
    
    // function to attain the minimum value
    public int getMin()
    {
    	if(minStack.isEmpty())
    	{
    		return 999999999;
    	}
    	return minStack.peek();
    }
    
    // keeps track of pushing values into max and min stacks and adding value into main stack.
    public void push(int inputValue)
    {

    	if(inputValue >= getMax())
    	{
    		maxStack.push(inputValue);
    	}
    	
    	if(inputValue <= getMin())
    	{
    		minStack.push(inputValue);
    	}
    	
    	super.push(inputValue);
    }

   // keeps track of removing values from max and min stacks and returning top value from main stack.
    public Integer pop()
    {
    	
    	if(!super.isEmpty())
    	{
    		int top = super.pop();
    		if(top == getMax() && !maxStack.isEmpty())
    		{
    			maxStack.pop();
    		}
    	
    		if(top == getMin() && !minStack.isEmpty())
    		{
    			minStack.pop();
    		}
    	
    		return top;
    	}
    	
    	return null;
    }
    
	public static void main(String[] args)
	{
		StackWithMinMax mainStack = new StackWithMinMax();
		Scanner in = new Scanner(System.in);		
		System.out.println("Enter the stack size: ");
		int count = in.nextInt();
		
		for(int i = 0 ; i < count ; i++)
		{
			System.out.println("Input value " +(i+1) +" into stack ");
			mainStack.push(in.nextInt());
		}
		
		System.out.println("The initial stack looks like this: "+mainStack.toString());
		System.out.println("The min value currently is: " +mainStack.getMin());
		System.out.println("The max value currently is: " +mainStack.getMax());
		mainStack.pop();
		mainStack.pop();
		System.out.println("The new stack looks like this: "+mainStack.toString());
		System.out.println("The min value currently is: " +mainStack.getMin());
		System.out.println("The max value currently is: " +mainStack.getMax());		
		in.close();		
	}
}
