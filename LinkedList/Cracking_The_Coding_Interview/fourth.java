import java.util.Scanner;

/*
 * Cracking the coding interview 
 * Chapter: Linked Lists
 * Solution: 2.4
 * Write code to partition a linked list around a value x, such that all nodes less than
 * x come before all nodes greater than or equal to x.
 * Author: Viveka Aggarwal
 */

public class fourth {
		node head;
		
		fourth() {
			head = null;
		}
		
		fourth(int data) {
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
		
		public void partitionList(int val) {
			
			if(head == null) {
				System.out.println("Empty list cannot be partitioned");
				return;
			}
			
			fourth LL1 = new fourth();
			fourth LL2 = new fourth();
			
			while(head != null) {
				node temp = head.next;
				head.next = null;
				
				if(head.data < val) {
					LL1.addToList(head);
					System.out.println("reached here <");
				} else if(head.data > val) {
					LL2.addToList(head);
					System.out.println("reached here >");
				} else {
					if(LL2.head == null) {
						 LL2.head = head;
						}
					else {
					head.next = LL2.head;
					LL2.head = head;
					System.out.println(LL2.toString());
					}
				}
				head = temp;
			}
			
			if(LL1.head == null) {
				head = LL2.head;
				return;
			}
			if(LL2.head == null) {
				head = LL1.head;				
				return;
			}
			
			head = LL1.head;
			node p = head;
			while(p.next != null) {
				p = p.next;
			}
			p.next = LL2.head;	
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
			fourth LL = new fourth(1);
			LL.addToList(5);
			LL.addToList(3);
			LL.addToList(3);
			LL.addToList(5);
			LL.addToList(0);
			LL.addToList(1);
			LL.addToList(4);
			
			//output format plus getting index value from user
			System.out.println("Current list: " +LL.toString());
			System.out.println("Enter the data value: ");
			int input = in.nextInt();
			LL.partitionList(input);
			System.out.println("The new partitioned list is: "+LL.toString()); 
			in.close();		
		}
}