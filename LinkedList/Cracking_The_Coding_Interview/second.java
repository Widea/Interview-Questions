import java.util.Scanner;
/*
 * Cracking the coding interview 
 * Chapter: Linked Lists
 * Solution: 2.2
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * Author: Viveka Aggarwal
 */

public class second {
	node head;
	int count;
	
	second(int data) {
		head = new node(data);
		count = 1;
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
	
	/*
	 * when the input index value is out of range
	 * the program output the data value at position
	 * "listLength - input" from end
	 */
	public int nFromLast(int index) {
		node first = head;
		node second = head;
		
		// if index is not in range, index is length - input
		if(index > count)
			index = index - count;
		
		// if index equals list length, return head
		if(index == count)
			return head.data;
		
		// run the first counter till it reaches the required index position
		while(index > 0) {
			first = first.next;
			index--;
		}
		
		// start running the second counter, until the first counter reaches the last node
		while(first != null) {
			second = second.next;
			first = first.next;
			}
		
		return second.data;
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
		Scanner in = new Scanner(System.in);
		
		// creating the linked list
		second LL = new second(1);
		LL.addToList(2);
		LL.addToList(3);
		LL.addToList(4);
		LL.addToList(5);
		LL.addToList(6);
		LL.addToList(7);
		LL.addToList(8);
		
		//output format plus getting index value from user
		System.out.println("Current list: " +LL.toString());
		System.out.println("Enter the index value: ");
		int index = in.nextInt();
		System.out.println("The nth data value from end at the input index position is: " + LL.nFromLast(index));
		in.close();		
	}
}