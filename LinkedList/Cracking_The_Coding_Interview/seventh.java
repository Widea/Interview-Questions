import java.util.Stack;

/*
 * Cracking the coding interview 
 * Chapter: Linked Lists
 * Solution: 2.7
 * Implement a function to check if a linked list is a palindrome.
 * Author: Viveka Aggarwal
 */

public class seventh {
	node head;
	seventh() {
		head = null;
	}
	
	seventh(int data) {
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
	
	public boolean isPalindrome() {
		if(this == null)
			return false;
		if(this.head == null)
			return false;
		
		node slow = head;
		node fast = head;
		Stack<Integer> buffer = new Stack<>();
		
		while(fast != null && fast.next != null) {
			buffer.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null) {
			slow = slow.next;
		}
		while(slow.next != null) {
			if(buffer.pop() != slow.data)
				return false;
			slow = slow.next;
		}
		return true;		
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
	
	public static void main(String[] args) {
		seventh LL = new seventh(1);
		LL.addToList(5);
		LL.addToList(3);
		LL.addToList(2);
		LL.addToList(0);
		LL.addToList(3);
		LL.addToList(5);
		LL.addToList(1);
		
		System.out.println("list: " +LL.toString());
		System.out.println("Is palindrome?: " +LL.isPalindrome());
	}
}