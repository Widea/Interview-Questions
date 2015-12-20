/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.7
 * Implement the "paint fill" function that one might see on many image editing programs. 
 * i.e., given a screen (represented by a two-dimensional array of colors), a point, 
 * and a new color, fill in the surrounding area until the color changes from the original color.
 */

public class seventh {
	enum color {
		black, blue, red, yellow, green, purple, brown, orange;
	}
	
	boolean fillColor(color[][] area, int x, int y, color orig_color, color new_color) {
		if(x < 0 || x > area[0].length || y < 0 || y > area.length)
			return false;
		
		if(area[y][x] == orig_color) {
			area[y][x] = new_color;
			fillColor(area, x-1, y, orig_color, new_color);
			fillColor(area, x+1, y, orig_color, new_color);
			fillColor(area, x, y-1, orig_color, new_color);
			fillColor(area, x, y+1, orig_color, new_color);
		}
		
		return true;
	}
	
	boolean fillColor(color[][] area, int x, int y, color new_color) {
		if(area == null)
			return false;
		
		if(area[y][x] == new_color) 
			return false;
		return fillColor(area, y, x, area[y][x], new_color );
	}
	
	public static void main(String[] a) {
		
	}
}
