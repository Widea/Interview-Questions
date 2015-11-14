// Program to create a queue using linked list

public class QueueUsingLinkedList {
	node front, rear;
	private int count;
	
	public class node {
		node next;
		int data;
		
		node(int data) {
			this.data = data;
		}
	}
	
	QueueUsingLinkedList() {
		count = 0;
		front = rear = null;
	}
	
	QueueUsingLinkedList(int data) {
		count = 1;
		front = new node(data);
		rear = front;
	}
	
	int size() {
		return count;
	}
	
	boolean isEmpty() {
		return size() == 0;
	}
	
	void enqueue(int data) {
	 if(size() == 0) {
		count = 1;
		front = new node(data);
		rear = front; 
		return;
	 }
	 
	 rear.next = new node(data);
	 rear = rear.next;
	 count++;
	}
	
	int dequeue() {
		if(size() == 0) {
			System.out.println("empty list");
			return Integer.MIN_VALUE;
		}
		front = front.next;
		count--;
		if(count == 0) {
			System.out.println("empty list");
			return Integer.MIN_VALUE;
		}
		return front.data;
	}
	
	int peekFront() {
		if(size() == 0) {
			System.out.println("empty list");
			return Integer.MIN_VALUE;
		}
		return front.data;
	}
	
	int peekRear() {
		if(size() == 0) {
			System.out.println("empty list");
			return Integer.MIN_VALUE;
		}
		return rear.data;
	}
	
	public static void main(String[] a) {
		QueueUsingLinkedList q = new QueueUsingLinkedList(1);
		System.out.println("Hello");
		System.out.println(q.peekFront() + " " + q.peekRear());
		q.dequeue();
		q.dequeue();
		System.out.println(q.peekFront() + " " + q.peekRear());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.peekFront() + " " + q.peekRear());
	}
	
}
