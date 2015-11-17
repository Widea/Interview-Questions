// Program to check if two rectangles are overlapping, given the coordinates of the diagonals of both the rectangles

public class OverlappingRectangles {
	coordinates top, bottom;
	
	OverlappingRectangles(int x1, int y1, int x2, int y2 ) {
		top = new coordinates(x1, y1);
		bottom = new coordinates(x2, y2);
	}
	
	public class coordinates {
		private int x, y;
		
		coordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int getX() {
			return x;
		}
		
		int getY() {
			return y;
		}
	}
	
	static boolean isOverlapping(OverlappingRectangles r1, OverlappingRectangles r2) {
		
		//check if the two rectangles are either on each other's left/right
		if(r1.top.getX() >= r2.bottom.getX() || r2.top.getX() >= r1.bottom.getX()) {
			return false;
		}
		
		//check if the two rectangles are either on each other's top/bottom
		if(r1.top.getY() <= r2.bottom.getY() || r2.top.getY() <= r1.bottom.getY()) {
			return false;
		}		
		return true;
	}
	
	
	public static void main(String[] a) {
		OverlappingRectangles r1 = new OverlappingRectangles(1,2,3,4);
		OverlappingRectangles r2 = new OverlappingRectangles(5,6,7,8);
	    
	    OverlappingRectangles R1 = new OverlappingRectangles(0, 10, 10, 0);
		OverlappingRectangles R2 = new OverlappingRectangles(5, 5, 15, 0);
	    
		// Non overlapping
		System.out.println(isOverlapping(r1, r2));
		
		// Overlapping
		System.out.println(isOverlapping(R1, R2));
		
	}
}
