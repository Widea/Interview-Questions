package moderate;
/*
 * Cracking the coding interview 
 * Chapter: Moderate
 * Solution: 17.13
 * Consider a simple node-like data structure called BiNode, which has pointers to two other nodes. 
 * The data structure BiNode could be used to represent both a binary tree 
 * (where nodel is the left node and right is the right node) or a doubly linked list 
 * (where nodel is the previous node and right is the next node). 
 * Implement a method to convert a binary search tree (implemented with BiNode) into a doubly linked list. 
 * The values should be kept in order and the operation should be performed in place (that is, on the original data structure).
 * Author: Viveka Aggarwal
 */

public class thirteen {
	public static class biNode {
		biNode left;
		biNode right;
		int data;
		
		biNode(int data) {
			left = null;
			right = null;
			this.data = data;
		}
		
		biNode(biNode left, biNode right, int data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
	
	public static class nodePair {
		biNode head;
		biNode tail;
		
		nodePair(biNode head, biNode tail) {
			this.head = head;
			this.tail = tail;
		}
	}
	
	static nodePair createLL(biNode root) {
		
		if (root == null) {
			return null;
		}
	
		nodePair part1 = createLL(root.left);
		nodePair part2 = createLL(root.right);
	
		if (part1 != null) {
			concat(part1.tail, root);
		}
	
		if (part2 != null) {
			concat(root, part2.head);
		}
	
		return new nodePair(part1 == null ? root : part1.head, part2 == null ? root : part2.tail);
	}
	
	static void concat(biNode one, biNode two) {
		one.right = two;
		two.left = one;
	}
	
	static biNode createTree() {
		biNode[] nodes = new biNode[7];
		
		for(int i = 0; i < 7 ; i++)
			nodes[i] = new biNode(i);

		nodes[4].left = nodes[2];
		nodes[4].right = nodes[5];
		nodes[2].left = nodes[1];
		nodes[2].right = nodes[3];
		nodes[5].right = nodes[6];
		nodes[1].left = nodes[0];
		return nodes[4];
	}
	
	static void printList(biNode head) {
		for (biNode node = head; node != null; node = node.right) {
			if (node.right != null && node.right.left != node) {
				System.out.print("inconsistent node: " + node);
			}
			System.out.print(node.data + "->");
		}
		System.out.println();
	}
	
	static void printTree(biNode root) {
		if(root != null){
			printTree(root.left);
			System.out.print(root.data + " ");
			printTree(root.right);
		}
	}
	
	public static void main(String[] args) {
		biNode root = createTree();
		System.out.println();
		printTree(root);
		nodePair LL = createLL(root);
		System.out.println();
		printList(LL.head);
	}
}