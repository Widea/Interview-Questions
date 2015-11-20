// Program to implement a circular queue

public class CircularQueue {
	int[] a;
	int front;
	int rear;
	
	CircularQueue() {
		a = new int[10];
		front = rear = -1;
	}
	
	CircularQueue(int capacity) {
		a = new int[capacity];
		front = rear = -1;
	}

	void enqueue(int data) {
		int c = (rear+1) % a.length;
		
		if(c == front) {
			System.out.println("Overflow");
			return;
		} else {
			rear = c;
			a[rear] = data;
			
			// Empty queue
			if(front == -1)
				front = 0;
		}
	}
	
	int dequeue() {
		if(isEmpty()){
			System.out.print("Empty list");
			return Integer.MIN_VALUE;
		}
		int out = a[front];
		
		if(front == rear)
			front = rear = -1;
		else
			front = (front+1) % a.length;
		return out;
	}
	
	void print() {
		if(front == -1){
			System.out.println("Empty list");
			return;
		}
		System.out.println();
		for(int i = front; i <= rear ; i++) {
			System.out.print(a[i] + " : ");
		}
	}
	
	boolean isEmpty() {
		return front == -1;
	}
	
	void clear() {
		front = rear = -1;
	}
	
	public static void main(String[] a) {
		CircularQueue q = new CircularQueue(5); 
		System.out.println(q.isEmpty());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.print();
		q.dequeue();q.dequeue();
		q.print();
		System.out.println(q.isEmpty());
		q.clear();
		q.print();
		
	}
 }
