import java.util.TreeMap;

// Program to calculate the distance of each column in a given binary tree in java
// Reference : http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/

public class SumOfColumnsBT {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	void printTree(Node start) {
		if(start == null) {
			return;
		}
		
		printTree(start.left);
		System.out.print(start.data + " ");
		printTree(start.right);
	}
	
	void sumOfColumns(Node start) {
		if(start == null)
			return;
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		sumHelper(start, 0, map);
		
		if(!map.isEmpty()) {
		    // List list = new LinkedList(map.entrySet());
			//Collections.sort(list);
			System.out.println(map.entrySet());
		}
	}
	
	void sumHelper(Node start, int dist, TreeMap<Integer, Integer> map) {
		if(start == null)
			return;
		
		// In order traversal
		sumHelper(start.left, dist-1, map);
		
		int prevSum = map.get(dist) == null? 0 : map.get(dist);
		map.put(dist, prevSum + start.data);
		
		sumHelper(start.right, dist+1, map);
		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        SumOfColumnsBT bt = new SumOfColumnsBT();
        bt.printTree(root);
        bt.sumOfColumns(root);
        
	}
}
