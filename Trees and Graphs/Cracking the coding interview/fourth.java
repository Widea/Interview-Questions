/* Cracking the coding interview
 * Chapter : Trees and Graphs
 * Question: 4.4
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 * Author : Viveka Aggarwal
 */
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class fourth {

	public static class TreeNode
	{
		TreeNode left;
		TreeNode right;
		Object data;
	
		TreeNode(int inputData)
		{
			data = inputData;
		}
	}
	
	public static ArrayList<LinkedList<TreeNode>> getList(TreeNode root)
	{
		if(root == null)
			return null;
		
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>> () ;
		getLinkedList(root, 0, list);		
		return list;
		
	}
	
	public static void getLinkedList(TreeNode node, int level, ArrayList<LinkedList<TreeNode>> list ) 
	{	
		if(node == null)
		{
			return;
		}
		
		LinkedList<TreeNode> newList = new LinkedList<TreeNode>();
		
		if(list.size() == level)
		{
			list.add(newList);
		}		
		else
		{
			newList = list.get(level);
		}
		
		newList.add(node);
		
		getLinkedList(node.left , level + 1, list);
		getLinkedList(node.right, level + 1, list);
	}
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(7);
		TreeNode firstLeft = new TreeNode(5);
		TreeNode firstRight = new TreeNode(9);
		TreeNode second1Left = new TreeNode(3);
		TreeNode second1Right = new TreeNode(6);
		TreeNode second2Left = new TreeNode(8);
		TreeNode second2Right = new TreeNode(11);
		TreeNode thirdLeft = new TreeNode(2);
		TreeNode thirdRight = new TreeNode(4);

		// Tree creation
		root.left = firstLeft;
		root.right = firstRight;
		firstLeft.left = second1Left;
		firstLeft.right = second1Right;
		firstRight.left = second2Left;
		firstRight.right = second2Right;
		second1Left.left = thirdLeft;
		second1Left.right = thirdRight;
		second2Right.right = new TreeNode(12);
		
		ArrayList<LinkedList<TreeNode>> result = getList(root);
		
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) 
		{
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Linked list at depth " + depth + ":");
			while(i.hasNext())
			{
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}		
	}
}
