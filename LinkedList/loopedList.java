// program to check for possible loop/loops in a given linkedlist!

import java.util.Iterator;
import java.util.LinkedList;

public class loopedList{

// a node class for defining a simple singly linkedlist	
 static class node
{
	node next;
	Object data;

	public node(int val)
	{
		data = val;
		next = null;
	}
}

 // function to check for a loop in the given linkedlist
 public static boolean isLooped(node start)
 {
	 node slow = start, fast = start;
	 
	 while(fast.next != null)
	 {
		 fast = fast.next.next;
		 slow = slow.next;
		 
		 if(fast == slow)
			 return true;
	 } 
 return false;
 }

 public static void main(String[] args){
	
	 node a = new node(21);
	 node b = new node(2);
	 node c= new node(23);
	 node d = new node(212);
	 node e= new node(3);
	 
	 a.next = b;
	 b.next = c;
	 c.next = d;	 
	 d.next = c;
	 e.next = c;
	 
	 System.out.println(isLooped(a));	 
	 
 }
 
 

}
