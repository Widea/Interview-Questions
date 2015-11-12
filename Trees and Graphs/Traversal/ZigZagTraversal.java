import java.util.Stack;

// Program to implement zig-zag traversal in binary tree. 
// Each level is traversed in the opposite direction of the previous one!
// Reference: http://www.java2blog.com/2014/08/spiralzigzag-level-order-traversal-of.html

public class ZigZagTraversal {
	static class node {
		int data;
		node left;
		node right;
		
		node(int data) {
			this.data = data;
		}
	}
	
	static node createTree() {
		node rootNode =new node(40);  
		node node20=new node(20);  
        node node10=new node(10);  
		node node30=new node(30);  
		node node60=new node(60);  
		node node50=new node(50);  
		node node70=new node(70);  
		node node5=new node(5);  
		node node55=new node(55);  
		    
		rootNode.left=node20;  
		rootNode.right=node60;  
		    
	    node20.left=node10;  
		node20.right=node30;  
		    
		node60.left=node50;  
		node60.right=node70;  
		node10.left=node5;  
		node50.right=node55;  
		    
		return rootNode;  
	}
	
	static String traversal(node start) {
		if(start == null)
			return "Empty tree";
		StringBuffer output = new StringBuffer("");
		Stack<node> stack = new Stack<>();
		stack.push(start);  
        
        boolean directionFlag=false;  
        
        while(!stack.isEmpty()) {
        	Stack<node> temp = new Stack<>();
        	while(!stack.isEmpty()) {
        		node tempNode = stack.pop();
        		output.append(tempNode.data+"  ");
        		if(!directionFlag) {
        			if(tempNode.left != null)
        				temp.push(tempNode.left);
        			if(tempNode.right != null)
        				temp.push(tempNode.right);
        		} else {
        			if(tempNode.right != null)
        				temp.push(tempNode.right);
        			if(tempNode.left != null)
        				temp.push(tempNode.left);
        		}
        	}
        	directionFlag = !directionFlag;
        	stack = temp;
        	output.append('\n');
        }
        return output.toString();
     }  

	public static void main(String[] args) {
		node start = createTree();
		System.out.println(traversal(start));
	}
}
