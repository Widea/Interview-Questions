public class fifth {

	public static class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int data;
	
		TreeNode(int inputData)
		{
			data = inputData;
		}
	}
	
	public static boolean checkTreeForBST(TreeNode root)
	{
		if(root == null)
		{
			System.out.println("Empty tree!!!");
			return true;
		}
	
		return checkTreeForBST(root, null, null);
	}
	
	public static boolean checkTreeForBST(TreeNode node, Integer min, Integer max)
	{
		if(node == null)
			return true;
		
		if((min != null && node.data <= min) || (max != null && node.data > max))
		{
			return false;
		}
	
		if(!checkTreeForBST(node.left, min, node.data)||
		!checkTreeForBST(node.right, node.data, max))
			return false;
		else
		return true;	
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
		
		System.out.println(checkTreeForBST(root));
	}
}
