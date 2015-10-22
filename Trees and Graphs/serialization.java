import java.io.*;

// Program to implement serialization and de-serialization of a given binary tree. 

public class serialization {
	static int index = 0;
	public static class treeNode {
		int value;
		treeNode left;
		treeNode right;
		
		treeNode(int value) {
			this.value = value;
			left = right = null;
		}
	}
	
	//pre-order serialization of given binary tree
	// ( indicates the start of a new level
	// # indicates a null node
	static String serialize(treeNode start) {
		if(start == null)
			return "#";
		
		return (String.valueOf(start.value)+serialize(start.left) + serialize(start.right));		
	}
	
	static treeNode deserialize(String treeValue) {
		if (treeValue == null || treeValue.length() == 0)
			return null;
		return deserialize1(treeValue);
	}
	
	static treeNode deserialize1(String treeValue) {
		if(index >= treeValue.length() )
			return null;
		
		if(treeValue.charAt(index) == '#')
			{
			index++;
			return null;
			}
		
		treeNode node = new treeNode(Character.getNumericValue(treeValue.charAt(index)));
		index++;
		node.left = deserialize(treeValue);
		node.right = deserialize(treeValue);
		
		return node;
	}
	
	// pre order printing of binary tree
	static String printTree(treeNode node) {
		if (node == null)
			return "null";
		
		return String.valueOf(node.value) +" ( "+printTree(node.left) + " ) "+printTree(node.right);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		treeNode root = new treeNode(1);
		treeNode node2 = new treeNode(2);
		treeNode node3 = new treeNode(3);
		treeNode node4 = new treeNode(4);
		treeNode node5 = new treeNode(5);
		treeNode node6 = new treeNode(6);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;	
		
		
		try
	      {
		 // Serialization of the tree
	         FileOutputStream fileOut =
	         new FileOutputStream("/serialize.txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(serialize(root));
	         out.close();
	         fileOut.close();
	         
	         // de-serialization of the tree
	         FileInputStream fileIn = new FileInputStream("/serialize.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         treeNode tree = deserialize((String)in.readObject());
	         System.out.println("Printing the tree: " + printTree(tree));
	         in.close();
	         fileIn.close();
	         
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }

	}	
}
