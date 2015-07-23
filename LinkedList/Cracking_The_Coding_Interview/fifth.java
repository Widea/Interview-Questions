/*
 * Cracking the coding interview 
 * Chapter: Linked Lists
 * Solution: 2.5
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
 * of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * FOLLOW UP: Suppose the digits are stored in forward order. Repeat the above problem
 * Author: Viveka Aggarwal
 */

public class fifth {
	node head;
	int count;
	
	fifth() {
		head = null;
		count = 0;
	}
	
	fifth(int data) {
		head = new node(data);
		count = 1;
	}	
	
	public void addToList(int data) {		
		if(head == null) {
			head = new node(data);
			count = 1;
			return;
		}
		node temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = new node(data);
		count++;
	}
	
	public void addToList(node in) {		
		if(head == null) {
			head = in;
			count = 1;
			return;
		}
		node temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = in;
		count++;
	}
	
	public class node {
		node next;
		int data;
		
		node(int data) {
			this.data = data;
			next = null;
		}			
	}
	
	@Override
	public String toString(){
		if(head == null)
			return "Empty List";
		node temp = head;
		StringBuffer output = new StringBuffer("");
		while(temp != null) {
			output.append(temp.data);
			temp = temp.next;
		}
		return output.toString();
	}
	
	public String reverseString(){
		return new StringBuffer(this.toString()).reverse().toString();
	}
	
	public static fifth addReversedLists(fifth LL1,fifth LL2) {
		if(LL1 == null && LL2 == null )
			return null;		
		if(LL1 == null)
			return LL2;
		if(LL2 == null)
			return LL1;
		
		int carry = 0, curr = 0;
		node p1, p2;
		fifth LL3 = new fifth();
		
		if(LL1.count >= LL2.count) {
			p1 = LL1.head;
			p2 = LL2.head;
		} else {
			p2 = LL1.head;
			p1 = LL2.head;
		}
		
		while(p1 != null) {		
		   while(p2 != null) {
			curr = p1.data + p2.data;	
			if(carry != 0) {
				curr = curr + carry;
				carry = 0;
			}
			if(curr >= 10) {
				curr = curr - 10;
				carry = 1;
			}
			LL3.addToList(curr);
			p1 = p1.next;
			p2 = p2.next;
		   }
		   
		   while(p1 != null) {
			   curr = p1.data;				
				if(carry != 0) {
					curr = curr + carry;
					carry = 0;
				}

				if(curr >= 10) {
					curr = curr - 10;
					carry = 1;
				}
				LL3.addToList(curr);		
				p1 = p1.next;
			}		   
		}

		if(carry == 1)
			LL3.addToList(1);

		return LL3;
	}
	
	public static void main(String[] args) {
		// creating the linked list
		fifth LL1 = new fifth(1);
		LL1.addToList(5);
		LL1.addToList(3);
		LL1.addToList(9);
		
		fifth LL2 = new fifth(5);
		LL2.addToList(9);
		LL2.addToList(1);
		LL2.addToList(4);
		
		fifth LL3 = new fifth(9);
		LL3.addToList(9);
		
		fifth LL4 = new fifth(9);
		
		//output format plus getting index value from user
	
		System.out.println();
		System.out.println("***** OUTPUT *****");
		System.out.println();
		System.out.println("Case 1: When the digits are stored in reverse order");
		System.out.println("Test Case: 1");
		System.out.println("Actual List1: " +LL1.reverseString());
		System.out.println("Actual List2: " +LL2.reverseString());
		System.out.println("Sum: " +addReversedLists(LL1,LL2).reverseString());
		System.out.println();
		System.out.println("Test Case: 2");
		System.out.println("Actual List1: " +LL1.reverseString());
		System.out.println("Actual List2: " +LL3.reverseString());
		System.out.println("Sum: " +addReversedLists(LL1,LL3).reverseString());
		System.out.println();
		System.out.println("Test Case: 3");
		System.out.println("Actual List1: " +LL3.reverseString());
		System.out.println("Actual List2: " +LL2.reverseString());
		System.out.println("Sum: " +addReversedLists(LL3,LL2).reverseString());
		System.out.println();
		System.out.println("Test Case: 4");
		System.out.println("Actual List1: " +LL4);
		System.out.println("Actual List2: " +LL3.reverseString());
		System.out.println("Sum: " +addReversedLists(LL4,LL3).reverseString());
	}
}
