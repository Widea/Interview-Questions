// Program to implement a min-binary heap

import java.util.ArrayList;
import java.util.Comparator;

public class Heap {
	private int size;
	final private ArrayList<Node> heap;
	final private Comparator<Integer> comparator;
	
	public class Node {
		Integer element;
		int position;
		
		Node(Integer element) {
			this.element = element;
		}
	}
	
	static Comparator<Integer> com = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 < o2)
				return -1;
			else if(o1 == o2)
				return 0;
			return 1;
	}
	};
	
	Heap() {
		heap = new ArrayList<Node>();
		size = 0;
		this.comparator = com;
	}
	
	void insert(Integer val) {
		Node node = new Node(val);
		node.position = size;
		size++;
		heap.add(node);
		shiftUp(node);
	}
	
	void shiftUp(Node node) {
		int index = node.position;
		int parent;
		while(index > 0 && comparator.compare(heap.get(index).element, (heap.get(parent = getParent(index))).element) <= 0) {
			swap(index, parent);
			index = parent;
		}
	}
	
	void swap(int index, int parent) {
		Node temp = heap.get(index);
		temp.position = parent;
		
		Node temp_parent = heap.get(parent);
		temp_parent.position = index;
		
		heap.set(index, temp_parent);
		heap.set(parent, temp);
	}
	
	Integer pop() {
		if(size == 0)
			return null;
		
		Node output = heap.get(0);
		swap(0, size-1);
		heap.remove(size-1);
		size--;

		if(size > 0) {
			shiftDown(heap.get(0));
		}
		return output.element;
	}
	
	Integer peek() {
		if(size == 0)
			return null;
		return heap.get(0).element;
	}
	
	void shiftDown(Node node) {
		int index = node.position;
		int smallest, left = getLeft(index), right = getRight(index);
		
		if(left < size && heap.get(left).element < heap.get(index).element) {
			smallest = left; 
		} else {
			smallest = index;
		}
		
		if(right < size && heap.get(right).element < heap.get(index).element) {
			smallest = right; 
		}
		if(smallest != index) {
			swap(smallest, index);
			shiftDown(heap.get(smallest));
		}		
		
	}
	
	int getParent(int k) {
		return k/2;
	}
	
	int getLeft(int k) {
		return 2 * k;
	}
	
	int getRight(int k) {
		return (2 * k) + 1;
	}

	public static void main(String[] a) {
		Heap h = new Heap();
		h.insert(23);
		h.insert(4);
		h.insert(45);
		h.pop();
		h.insert(67);
		h.insert(2);
		h.insert(3);
		
		while(h.size > 0) {
			System.out.print(h.pop() + " ");
		}
		
	}
}
