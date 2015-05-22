// merging two sorted linked lists. (Increasing order) 
public class mergingSinglyLinkedLists{
	node head;
	
	public class node
	{
		Integer data;
		node next;	
		
		// parameterized constructor
		public node(int input)
		{
			data = input;
			next = null;
		}

		public node() {
			// TODO Auto-generated constructor stub
		}		
	}
	
	// parameterized constructor
	public mergingSinglyLinkedLists(int val)
	{
		head = new node(val);
	}
	
	//default constructor
	public mergingSinglyLinkedLists() {
	}

	// add a new node to the end of the linked list
	public void addToList(int val)
	{
		if(head == null)
		{
			head = new node(val);
			return;
		}
		
		node temp = head;
		node valNode = new node(val);
		
		while(temp.next != null)
		{
			temp = temp.next;
		}
		
		temp.next = valNode;
	}
	
	// print the list as a string. 
	@Override
	public String toString()
	{
		if(head == null)
			return "null";
		
		StringBuffer outputString = new StringBuffer(" ");
		node temp = head;
		
		while(temp != null)
		{
			outputString.append(temp.data + "  ");
			temp = temp.next;
		}
		return outputString.toString();
	} 
	
	// creates a new list and merges the given two lists into it.
	// Returns the new string
	public static mergingSinglyLinkedLists mergeIncreasingOrder1(mergingSinglyLinkedLists l1, mergingSinglyLinkedLists l2)
	{
		if(l1.head == null && l2.head == null) 
		{
			return null;
		}
		if (l2.head == null) 
		{
			return l1;
		}
		if(l1.head == null)
		{
			return l2;
		}
		
		mergingSinglyLinkedLists newList = new mergingSinglyLinkedLists();
		
		node l1i = l1.head;
		node l2i = l2.head;
		
		while(l1i != null || l2i != null)
		{
			if(l1i == null)
			{
			while(l2i != null)
			{
				newList.addToList(l2i.data);
				l2i = l2i.next;
			}
			break;
			}
			
			if(l2i == null)
			{
			while(l1i != null)
			{
				newList.addToList(l1i.data);
				l1i = l1i.next;
			}	
			break;
			}
			
			if(l1i.data <= l2i.data )
			{
				newList.addToList(l1i.data);
				l1i = l1i.next;
			}
			else
			{
				newList.addToList(l2i.data);
				l2i = l2i.next;
			}
		}
		
		return newList;
	}
	
	
	// does not create a new list, and merges the second list into the first one in ascending order.
	// returns the head of the merged list
	public static mergingSinglyLinkedLists mergeIncreasingOrder2(mergingSinglyLinkedLists l1, mergingSinglyLinkedLists l2)
	{
		node l1i = l1.head;	
		node l2i = l2.head;
		
		if(l1i == null && l2i == null) 
		{
			return null;
		}
		if (l2i == null) 
		{
			return l1;
		}
		if(l1i == null)
		{
			return l2;
		}

		if(l1i.data > l2i.data)
		{
			node tmp = l1i;
			l1i = l2i;
			l2i = tmp;
		}
			
		while(l1i.next != null && l2i != null) 
		{
		    if (l1i.next.data <= l2i.data) 
		    {
		      l1i = l1i.next;
		    } 
		    else 
		    {
		      node tmp = l1i.next;
	   	      l1i.next = l2i;
	   	      l2i = tmp;
		    }
	     } 
		 
		if (l1i.next == null) 
		{	
			l1i.next = l2i;
		}
		
		if(l1.head.data > l2.head.data)
		return l2;
		else 
		return l1;
	}
			
	
	// main function
	//defines two lists
	// calls both the merging functions for merging the two list in ascending order
	public static void main(String[] args)
	{
		mergingSinglyLinkedLists list1 = new mergingSinglyLinkedLists(3);
		list1.addToList(7);
		list1.addToList(9);
		list1.addToList(15);list1.addToList(51);
		mergingSinglyLinkedLists list2 = new mergingSinglyLinkedLists(6);
		list2.addToList(7);
		list2.addToList(8);
		list2.addToList(9);
		
		System.out.println("list1: " +list1.toString());
		System.out.println("list2: " +list2.toString());
		System.out.println("Merged list in increasing order(creating a new list): " +mergeIncreasingOrder1(list1, list2).toString());
		
		System.out.println("Merged list in increasing order(without creating a new list): " +mergeIncreasingOrder2(list1, list2).toString());
	}
}
