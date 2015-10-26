import java.util.Stack;

public class reverseLinkedList {
	node head;
	
	public static class node {
		node next;
		int data;
		
		node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	reverseLinkedList(int data) {
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
	
	void addInBetween(node curr, int data) {
		if(curr == null) {
			curr = new node(data);
			return;
		}
			if(curr.next == null) {
			curr.next = new node(data);
			return;
		}
			node temp = head;
			while(temp.data != curr.data) {
				temp = temp.next;
			}
			
			node n = new node(data);
			n.next = curr.next;
			curr.next = n;
			
	}
	
	public String print() {
		if(head == null)
			return "Empty list!!!";
		
		node temp = head;
		
		StringBuffer out = new StringBuffer("");
		
		while(temp != null) {
			out.append(temp.data);
			temp = temp.next;
		}
			return out.toString();
	}
	
	public void reverseListWithoutBuffer() {
		if(head == null || head.next == null)
			return;

		node prev = null;
		node curr = head;
		node nex;
		
		while(curr != null) {
			nex = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nex;
		}
		head = prev;
	}
	
	public void reverseListWithBuffer() {
		if(head == null || head.next == null)
			return;
		Stack<node> s = new Stack<>();
		node temp = head; 
		while(temp != null) {
			s.push(temp);
			temp = temp.next;
		}
		head = s.pop();
		temp = head;
		while(!s.isEmpty()) {
			temp.next = s.pop();
			temp = temp.next;
		}
		temp.next = null;
	}
	
	public static void main(String[] args)	{
		reverseLinkedList newList = new reverseLinkedList(1);
		newList.addToList(2);	
		newList.addToList(3);
		newList.addToList(4);
		newList.addToList(5);
		newList.addToList(6);
		newList.addToList(7);
		newList.addToList(8);
				
		System.out.println(newList.print());
		newList.reverseListWithoutBuffer();

		//newList.reverseListWithBuffer();
		System.out.println(newList.print());
		
	}
	
	
}
