/*
 * Cracking the coding interview 
 * Chapter: Linked Lists
 * Solution: 2.3
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a- >b- >d->e
 * Author: Viveka Aggarwal
 */

public class third {
		
		static class node {
			node next;
			char data;
			
			node(char data) {
				this.data = data;
				next = null;
			}
		}
		
		static void removeNode(node input) {
			
			if(input == null) {
				System.out.println("Empty node");
				return;
			}
			
			if(input.next == null) {
				System.out.println("Cannot delete node");
				return;
			}
			
			input.data = input.next.data;
			input.next = input.next.next;
		}
		
		static String printList(node in) {
			if(in == null)
				return "Empty List";
			
			node temp = in;
			StringBuffer output = new StringBuffer("");	
			
			while(temp != null){
				output.append(temp.data);
				temp = temp.next;
			}	
			
			return output.toString();
		}
		
		public static void main(String[] args) {
			node a = new node('a');
			node b = new node('b');
			node c = new node('c');
			node d = new node('d');
			node e = new node('e');
			node f = new node ('f');
			
			a.next = b;
			b.next = c;
			c.next = d;
			d.next = e;
			e.next = f;
			
			System.out.println("The current list: " +printList(a));
			System.out.println();
			System.out.println("* * * * * * Test Cases * * * * * * ");
			System.out.println("1. Input node: null");
			removeNode(null);
			System.out.println("2. Input node: f(last node)");
			removeNode(f);
			System.out.println("3. Input node: e");
			removeNode(e);
			System.out.println("The updated list:" +printList(a));
			System.out.println("4. Input node: a");
			removeNode(a);
			System.out.println("The updated list:" +printList(a));
		}
}
