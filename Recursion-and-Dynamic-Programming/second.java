import java.util.ArrayList;
import java.util.HashMap;

/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.2
 * Imagine a robot sitting on the upper left comer of an X by Y grid. 
 * The robot can only move in two directions: right and down. How many possible paths 
 * are there for the robot to go from (0, 0) to (X, Y) ?
 * FOLLOW UP: Imagine certain spots are "off limits," such that the robot cannot step on them. 
 * 			  Design an algorithm to find a path for the robot from the top left to the bottom right.
 */

public class second {
	class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	boolean getPath(int x, int y) {
		Point p = new Point(x, y);
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> map = new HashMap<>();
		return getPath(p, path, map);
	}
	
	boolean getPath(Point p, ArrayList<Point> list, HashMap<Point, Boolean> cache) {
		boolean isOrigin = (p.x == 0) && (p.y == 0);
		boolean success = false;
		
		if(cache.containsKey(p))
			return cache.get(p);
		
		if(isOrigin || getPath(new Point(p.x - 1, p.y), list, cache) ||getPath(new Point(p.x, p.y - 1), list, cache)) {
			success = true;
		}
		
		if(success == true) {
			list.add(p);
			cache.put(p, true);
		}
		
		return success;	
	}
	
	public static void main(String[] a) {
		
	}
}
