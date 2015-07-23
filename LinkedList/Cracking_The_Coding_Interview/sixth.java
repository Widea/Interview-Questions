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
		h.next = c;
			
	}
}
