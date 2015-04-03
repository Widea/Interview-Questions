/**
* @author Viveka Aggarwal
* @chapter #2 (Linked Lists)
* @question #1 (deleting duplicates with and without buffer)
**/

import java.util.HashMap;
import java.util.Map;


public class LinkedListDupicates{

node head;
int counter;

public class node{
	 node next;
     char value;
	
	public node(char inputValue){
		value = inputValue;
		next = null;
	}
	
	public char getValue(){
		return this.value;
	}
	
	public node getNext(){
		return this.next;
	}
	
	public void setValue(char inputVal){
	 this.value = inputVal;
	}
	
	public void setNext(node inputNode){
		this.next = inputNode;
	}
	
}

public LinkedListDupicates(char inputVal){
	head = new node(inputVal);
	head.setNext(null);
}

public void addToList(node addInput){
	node temp = head;
	while(temp.getNext() != null){
		temp = temp.getNext();
	}
	temp.next = addInput;
	addInput.next = null;
}

public void addToList(char addInput){
	node input = new node(addInput);
	node temp = head;
	while(temp.getNext() != null){
		temp = temp.getNext();
	}
	temp.next = input;
	input.next = null;
}

public void printList(){
	node temp = head;
	System.out.println();
	while(temp.getNext() != null){
		System.out.print(temp.getValue());
		temp = temp.getNext();
	}
	
	System.out.print(temp.getValue());
	System.out.println();
	System.out.println();
}

	public void removeDuplicatesWithBuffer() 
	{	
		Map<Character, Boolean> map = new HashMap<Character, Boolean>();
		node previous = null, current = head;
		
		if (head == null)
		{
			//Should return nothing to do.
			return;			
		}

		while (current != null) 
		{
			if (map.containsKey(current.value)) 
			{
				//Skip over it
				previous.next = current.next;
			} 
			else 
			{
				//Put in map and continue traversing
				map.put((Character) current.value, true);
				previous = current;
			}
			current = current.next;
		}		
	}


public void removeDuplicatesWithoutBuffer(){
	 node current = head, checkerPrev =null,checkerCurr=null;
	 	
		if (head == null || head.next == null)
		{
			//Should return nothing to do.
			return;			
		}
	 
		
	 while(current != null )
	 {
		 checkerPrev = current; 
		 checkerCurr = current.next;
		 
		 while(checkerCurr != null)
		 {
			 if(current.value == checkerCurr.value)
			 {
			 checkerPrev.next = checkerCurr.next;
			// checkerCurr = checkerPrev.next;
		     }
		     else
		     {
			 checkerPrev = checkerCurr;
		     }
			 checkerCurr = checkerCurr.next;
		 }//end of inner while
		 
		 current = current.next;
	 }	 //end of outer while
		 
	 } 		 

	





public static void main(String[] args)	{
	LinkedListDupicates newList = new LinkedListDupicates('H');
	newList.addToList('E');	
	newList.addToList('E');
	newList.addToList('E');
	newList.addToList('E');
	newList.addToList('O');
	newList.addToList('O');
	newList.addToList('!');
	
	//newList.addToList('!');
	System.out.print("List with duplicates:");
	newList.printList();
  // Use either based on requirement!
  newList.removeDuplicatesWithBuffer();
	newList.removeDuplicatesWithoutBuffer();
	System.out.print("List without duplicates:");
	newList.printList();
}

}

