import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// program to merge K sorted arrays in a time efficient manner!
// References : http://algorithms.tutorialhorizon.com/merge-k-sorted-arrays/ and http://www.java2s.com/Code/Java/Collections-Data-Structure/Minimumheapimplementation.htm

public class MergeKSortedArrays {
	public static class Heap<T> {
		  private int size;
		  final private ArrayList<Node> heap;
		  final private Comparator<T> comparator;

		  public class Node {
		    public T element;
		    public T array;
		    public int position;
		    
		    Node(T element, T array) {
		    	this.element = element;
		    	this.array = array;
		    }
		  }    

		  public Heap( Comparator<T> comparator ) {
		    size = 0;
		    heap = new ArrayList<Node>();
		    this.comparator = comparator;
		  }

		  public void insert( final T element , T array) {
		    size++;
		    Node node = new Node(element, array);
		    node.position = size-1;
		    heap.add(node);
		    decreaseKey( node );
		  }
		  
		  public Node pop() {
		    Node returnNode = heap.get(0);
		    exchange( 0, size-1 );
		    heap.remove(size-1);
		    size--;

		    if (size>0) {
		      minHeapify( heap.get(0) );
		    }
		    
		    return returnNode;
		  }

		  private final boolean decreaseKey( final Node node ) {
		    int index = node.position;
		    boolean modified = false;

		    while ( index>0 &&  comparator.compare(heap.get(parent(index)).element, heap.get(index).element ) >= 0 ) {
		      exchange( index, parent(index) );
		      index = parent(index);
		      modified = true;
		    }
		    return modified;
		  }

		  private final void minHeapify( final Node node ) {
		    int smallest;
		    int index = node.position;
		    int left = left(index);
		    int right = right(index);

		    if (left<size && comparator.compare(heap.get(left).element, heap.get(index).element) <= 0 )
		      smallest= left;
		    else
		      smallest = index;

		    if (right<size && comparator.compare(heap.get(right).element, heap.get(smallest).element ) <=0 )
		      smallest= right;
		    if (smallest!= index) {
		      exchange( index, smallest );
		      minHeapify( heap.get(smallest) );
		    }
		  }

		  private final void exchange( final int index, final int index2 ) {
		    Node temp = heap.get(index);
		    temp.position = index2;

		    Node temp2 = heap.get(index2);
		    temp2.position = index;

		    heap.set(index, temp2 );
		    heap.set( index2, temp);
		  }


		  private final int parent(final int i) {
		    return i/2;
		  }

		  private final int left(final int i) {
		    return 2*i;
		  }

		  private final int right(final int i) {
		    return 2*i+1;
		  }
	}
	
	static Comparator<Integer> comparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 < o2)
				return -1;
			else if(o1 == o2)
				return 0;
			return 1;
		}
	};
	
	Heap<Integer> heap;
	int[] output;
	
	int[] merge(int[][] A) {
		if(A == null)
			return null;
		heap = new Heap<Integer>(comparator);
		
		int num_of_arrays = A.length;
		
		if(num_of_arrays == 1)
			return A[0];
		
		int array_length = A[0].length;	
		int[] output = new int[num_of_arrays * array_length];
		int[] ptr = new int[num_of_arrays];
		Heap<Integer>.Node curr_min;
        
		Arrays.fill(ptr, 0);
		
		// Putting first element of each array into the heap.
		for(int i = 0 ; i < num_of_arrays ; i++) {
			if(array_length > 0) {
				heap.insert(A[i][ptr[i]], i);
			} else {
				return null;
			}
		}
		
		int count = 0;
		while(count < output.length) {
			curr_min = heap.pop();
			output[count] = curr_min.element;
			ptr[curr_min.array]++; 
			
			if (ptr[curr_min.array] < array_length) {
				heap.insert(A[curr_min.array][ptr[curr_min.array]], curr_min.array);				
			} else {
				heap.insert(Integer.MAX_VALUE, curr_min.array);
			}
			
			count++;
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[][] input = {{11,22,34,48},{25, 36, 44, 56}, {1, 12, 56, 89}};
		
		MergeKSortedArrays m = new MergeKSortedArrays();
		int[] output = m.merge(input);
		
		for(int i = 0 ; i < output.length ; i++) {
			System.out.print(output[i] + " ");
		}	
	}
}
