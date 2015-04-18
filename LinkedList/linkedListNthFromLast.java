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



// When the entered position is 0 or less, the last element is returned
// When the entered position is larger than the list, first element is returned. 
// If a null list is entered, the function returns a blank character!
public char returnnthvalue(int pos){

	node first, second;
	first = second = head;
	int k = 1;
	
	if (head == null )
	{
		//Should return empty character.
		return ' ';			
	}
	
	// move the second pointer to the nth position
	while(second.next != null && k < pos ){
		second = second.next;
		k++;
	}
	// move the second pointer to the last position.
	// keep moving the first pointer at the same pace till the second counter hits the last value.
	while(second.next != null){
		first = first.next;
		second = second.next;
	}
	
	// Always return the value of the first node.
	return first.value;

} 

	





public static void main(String[] args)	{
	LinkedListDupicates newList = new LinkedListDupicates('H');
	newList.addToList('E');	
	newList.addToList('L');
	newList.addToList('L');
	newList.addToList('O');
	newList.addToList('O');
	newList.addToList('!');
	newList.addToList('!');
	
	System.out.print("List with duplicates:");
	newList.printList();
  System.out.print("The nth element from last: ");
  System.out.println(newList.returnnthvalue(2));
	
}

}

