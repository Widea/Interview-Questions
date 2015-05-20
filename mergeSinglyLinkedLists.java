// merging two sorted linked lists. (Increasing order) 
public class mergingSinglyLinkedLists{
	node head;
	
	public class node
	{
		Integer data;
		node next;
	
		public node(int input)
		{
			data = input;
			next = null;
		}

		
	}
	
	public mergingSinglyLinkedLists(int val)
	{
		head = new node(val);
	}
	
	public mergingSinglyLinkedLists() {
	
	}

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
	
	// creates a new list
	public static mergingSinglyLinkedLists mergeIncreasingOrder1(mergingSinglyLinkedLists l1, mergingSinglyLinkedLists l2)
	{
		if(l1.head == null && l2.head == null) return null;
		if (l2 == null) return l1;
		
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
	
	
	// does not create a new list
	public static node mergeIncreasingOrder2(mergingSinglyLinkedLists l1, mergingSinglyLinkedLists l2)
		{
			if(l1.head == null && l2.head == null) return null;
			if (l2.head == null) return l1.head;
			if(l1.head == null) return l2.head;
			node temp;
			
			if(l1.head.data <= l2.head.data)
			{
				temp = l1.head;
			}
			else
			{
				temp = l2.head;
				l2.head = l1.head;
				l1.head = temp;
			}
			
			
			while(l1.head.next != null && l2.head != null) {
			    if (l1.head.next.data <= l2.head.data) {
			      l1.head = l1.head.next;
			    } else {
			      node tmp = l1.head.next;
			      l1.head.next = l2.head;
			      l2.head = tmp;
			    }
			  } 
			  if (l1.head.next == null) l1.head.next = l2.head;
			  return temp;
			}
			
	
	
	public static void main(String[] args)
	{
		mergingSinglyLinkedLists list1 = new mergingSinglyLinkedLists(1);
		list1.addToList(2);
		list1.addToList(7);
		list1.addToList(9);list1.addToList(19);
		mergingSinglyLinkedLists list2 = new mergingSinglyLinkedLists(5);
		list2.addToList(7);
		list2.addToList(8);
		list2.addToList(9);
		
		System.out.println("list1: " +list1.toString());
		System.out.println("list2: " +list2.toString());
		System.out.println("Merged list in increasing order(creating a new list): " +mergeIncreasingOrder1(list1, list2).toString());
		System.out.println("Merged list in increasing order(without creating a new list): " +mergeIncreasingOrder1(list1, list2).toString());
	}
}
