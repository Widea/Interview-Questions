import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/* Cracking the coding interview
 * Chapter : Trees and Graphs
 * Question: 4.4
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 * Author : Viveka Aggarwal
 */

public class fourth {
	static class node {
		int data;
		node left;
		node right;
		
		node(int data) {
			this.data = data;
			left = right = null;
		}
	}
		static void createLinkedLists(node root, ArrayList<LinkedList<node>> list, int level) {
			if(root == null)
				return;
			
			if(level == list.size()) {
				list.add(new LinkedList<node>());
			
			} 

			list.get(level).add(root);
			
			createLinkedLists(root.left , list, level + 1);
			createLinkedLists(root.right , list, level + 1);
		}
		
		static ArrayList<LinkedList<node>> createLinkedLists(node root) {
			ArrayList<LinkedList<node>> list = new ArrayList<LinkedList<node>>();
			createLinkedLists(root, list, 0);
			return list;
		}
		
	
	public static void main(String[] args) {
		node root = new node(7);
		node firstLeft = new node(5);
		node firstRight = new node(9);
		node second1Left = new node(3);
		node second1Right = new node(6);
		node second2Left = new node(8);
		node second2Right = new node(11);
		node thirdLeft = new node(2);
		node thirdRight = new node(4);

		// Tree creation
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = second1Left;
		firstLeft.right = second1Right;
		firstRight.left = second2Left;
		firstRight.right = second2Right;
		second1Left.left = thirdLeft;
		second1Left.right = thirdRight;
		second2Right.right = new node(12);
		
		ArrayList<LinkedList<node>> output= createLinkedLists(root);
		int c = 0;
		for(LinkedList<node> l : output) {
			Iterator i = l.listIterator();
			System.out.println("***** List at depth "+(c++)+" ******");
			while(i.hasNext()) {
				System.out.print(((node)i.next()).data + "  ");
			}
			System.out.println();
		}	
	}
}
