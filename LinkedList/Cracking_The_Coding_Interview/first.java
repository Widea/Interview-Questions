import java.util.HashMap;
import java.util.Map;

/* Cracking the coding interview
 * Chapter : Linked Lists
 * Question: 2.1
 * Write code to remove duplicates from an unsorted linked list. FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * Author : Viveka Aggarwal
 */

public class first {
	
	node head; 
	
	first() {
		head = new node();
	}
	
	first(char input) {
		head = new node(input);
	}
	
	public void addToList(char input) {
		node temp = new node(input);
		if(head == null)
			head = temp;
		node p = head;
		while(p.next != null) {
			p = p.next;
		}
		p.next = temp;
	}
	
	static class node {
		char data;
		node next;
		
		node() {
			data = '\0';
			next = null;
		}
		
		node(char data) {
			this.data = data;
			next = null;
		}
	}
	
	public String removeDupWithBuffer() {
		
		if(head == null)
			return null;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
	
		node prev = null;
		node cur = head;
		
	//	map.put(head.data, 1);
		
		while(cur != null) {
			char val = cur.data;
			
			if(!map.containsKey(val)) {
				map.put(val, 1);
				prev = cur;
			}
			
			else {
				prev.next = cur.next;
			}			
			cur = cur.next;	
		}					
		return this.toString();
	}
	
	public String removeDupWithoutBuffer() {
	
		if(head == null)
			return null;
		
		node outer = head;
		node innerPrev = null;
		node innerCur = null;
		
		while(outer != null) {
			char data = outer.data;
			innerPrev = outer;
			innerCur = innerPrev.next;
			
			while(innerCur != null) {
				if(innerCur.data == data) {
					innerPrev.next = innerCur.next;
				}
				
				else {
					innerPrev = innerCur;	
				}
				
				innerCur = innerCur.next;				
			}
			outer = outer.next;	
		}		
		return this.toString();
	}
		
	public String toString() {
		StringBuffer output = new StringBuffer("");
		node temp = head;
		while(temp != null) {
			output.append(temp.data);
			temp = temp.next;
		}		
		return String.valueOf(output);
	}
	
	public static void main(String[] args) {
		first LL = new first('H');
		LL.addToList('H');
		LL.addToList('E');
		LL.addToList('L');
		LL.addToList('L');
		LL.addToList('O');
		LL.addToList('O');
		LL.addToList('O');
		
		System.out.println("Input list: " +LL.toString());
	//	System.out.println("Remove duplicates with buffer: " +LL.removeDupWithBuffer());
		System.out.println("Remove duplicates without buffer: " +LL.removeDupWithoutBuffer());
	}
}


