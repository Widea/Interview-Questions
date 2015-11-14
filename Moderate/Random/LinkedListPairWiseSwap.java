// Program to swap elements in a linked list pair wise!

public class LinkedListPairWiseSwap {
	node head;
	
	class node {
		node next;
		int data;
		
		node(int data) {
			this.data = data;
		}
	}
	
	LinkedListPairWiseSwap(int data) {
		head = new node(data);
	}
	
	void addToList(int data) {
		if(head == null) {
			head = new node(data);
			return;
		}
		node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = new node(data);
	}
	
	void swapPairs() {
		node temp = head;
		while(temp != null && temp.next != null) {
			swapValue(temp, temp.next);
		temp = temp.next.next;	
		}
	}
	
	void swapValue(node a, node b) {
		int temp = a.data;
		a.data = b.data;
		b.data = temp;
	}
	
	void print() {
		if(head == null) {
			System.out.println("Empty list");
			return;
		}	
		node temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] a) {
		LinkedListPairWiseSwap list = new LinkedListPairWiseSwap(1);
		list.addToList(2);
		list.addToList(3);
		list.addToList(4);
		list.addToList(5);
		list.addToList(6);
		list.addToList(7);
		list.addToList(8);
		
		System.out.println();
		list.print();
		
		list.swapPairs();
		
		System.out.println();
		list.print();
	}
	
}
