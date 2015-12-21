import java.util.ArrayList;


/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.10
 * You have a stack of n boxes, with widths wi, heights hi and depths di. 
 * The boxes cannot be rotated and can only be stacked on top of one another if each 
 * box in the stack is strictly larger than the box above it in width, height, and depth. 
 * Implement a method to build the tallest stack possible, where the 
 * height of a stack is the sum of the heights of each box.
 */

public class tenth {
	static class Box {
		int width;
		int height;
		int depth;
		
		Box(int w, int h, int d) {
			width = w;
			height = h;
			depth = d;
		}
		
		boolean canBeBelow(Box b2) {
			if(this.width > b2.width && this.height > b2.height && this.depth > b2.depth) {
				return true;
			}
			return false;
		}
		
		boolean canBeOnTop(Box b2) {
			// This will the first box in the stack. 
			if(b2 == null)
				return true;
			
			if(this.width < b2.width && this.height < b2.height && this.depth < b2.depth)
				return true;
			
			return false;
		}
		
		@Override
		public String toString() {
			return "w: "+width+" h: "+height+" d: "+depth; 
		}
		
	}
	
	ArrayList<Box> getLongestStack(Box[] boxes, Box bottom) {
		ArrayList<Box> longest_stack = null;
		int max_height = 0;
		for(int i = 0; i < boxes.length ; i++) {
			if(boxes[i].canBeOnTop(bottom)) {
				ArrayList<Box> new_list = getLongestStack(boxes, boxes[i]);
				if(new_list.size() > max_height) {
					longest_stack = new_list;
					max_height = new_list.size();
				}
			}		
		}
		
		if(longest_stack == null)
			longest_stack = new ArrayList<Box>();
		
		if(bottom != null)
			longest_stack.add(bottom);
		
		return longest_stack;
	}
	
	
	
	public static void main(String[] a) {
		tenth test = new tenth();
		
		Box b1 = new Box(1, 2, 3); 
		Box b2 = new Box(2, 3, 4); 
		Box b3 = new Box(3, 4, 5);
		Box b4 = new Box(2, 4, 6);
		
		
		Box[] input = new Box[] {b1, b2, b3, b4, new Box(5, 6, 7), new Box(5, 8, 9), new Box(8, 9, 10)};
		
		System.out.println(test.getLongestStack(input, null));
		
	}
}
