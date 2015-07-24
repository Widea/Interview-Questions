/*
 * Cracking the coding interview 
 * Chapter: Linked Lists
 * Solution: 2.6
 * Given a circular linked list, implement an algorithm which returns the node 
 * at the beginning of the loop.
 * Author: Viveka Aggarwal
 */

public class sixth {
	
	public static class node {
		node next;
		int data;
		
		node(int data) {
			this.data = data;
			next = null;
		}			
	}
		
	public static node getBeginning(node head) {
		if(head == null)
			return null;
		node fast = head;
		node slow = fast;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;	
			// This is where the two nodes meet
			if(fast == slow) 
				break;
		}
	
		if(fast == null || fast.next == null)
			return null;
		
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast; // or return slow
	}
	
	public static void main(String[] args) {
		node a = new node(1);
		node b = new node(2);
		node c = new node(3);
		node d = new node(4);
		node e = new node(5);
		node f = new node (6);
		node g = new node (7);
		node h = new node (8);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = d;			
		
		System.out.println("The meeting point has data: " +getBeginning(a).data);
	}
}
