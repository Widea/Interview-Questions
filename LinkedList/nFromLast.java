import java.util.LinkedList;
import java.util.Scanner;

public class nFromLast{

	node head;
		
	class node
	{
		int data;
		node next;
		
		node(int inData)
		{
			data = inData;
			next = null;
		}	
	}		
		
	public void add(int value)
	{
		node temp = head;
		if(head == null)
		{
			head = new node(value);
			return;
		}
		
		while(temp.next != null)
			temp = temp.next;
		
		temp.next = new node(value);		
	}
		
	public void print()
	{
		node temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public int indexValue(int inputIndex)
	{		
		if(head == null)
		return 0;
		
		node first = head, second = head;
		int counter = 1;
		
		while(counter < inputIndex && first.next != null)
		{	
			first = first.next;
			counter ++;
		}
		
		while(first.next != null)
			{
			second = second.next;
			first = first.next;
			}
		
		return second.data;		
	}
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		nFromLast inputList = new nFromLast();
		
		System.out.println("Enter the number of list elements: ");
		int num = in.nextInt();
		
		for(int i = 1 ; i <= num ; i++ )
		{
			System.out.println("Enter the list value "+i +": ");
			inputList.add(in.nextInt());			
		}
		
		System.out.println("Enter the index number from end who's value you want to retreive: ");
		int index = in.nextInt();
		
		while(index > num)
		{
			System.out.println("Illegal, Re enter:");
			index = in.nextInt();
		}

		inputList.print();
		System.out.println("The value " +"is :" +inputList.indexValue(index));
		
	}
	
	
}
