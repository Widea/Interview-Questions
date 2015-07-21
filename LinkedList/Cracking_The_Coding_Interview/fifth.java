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
	
	fifth() {
		head = null;
	}
	
	fifth(int data) {
		head = new node(data);
	}	
	
	public void addToList(int data) {		
		if(head == null) {
			head = new node(data);
			return;
		}
		node temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = new node(data);
	}
	
	public void addToList(node in) {		
		if(head == null) {
			head = in;
			return;
		}
		node temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = in;
	}
	
	public class node {
		node next;
		int data;
		
		node(int data) {
			this.data = data;
			next = null;
		}			
	}
	
	
	public static void main(String[] args) {
		// creating the linked list
		fifth LL = new fifth(1);
		LL.addToList(5);
		LL.addToList(3);
		LL.addToList(3);
		LL.addToList(5);
		LL.addToList(0);
		LL.addToList(1);
		LL.addToList(4);
		
		//output format plus getting index value from user
		System.out.println("Current list: " +LL.toString());
		
	}
}