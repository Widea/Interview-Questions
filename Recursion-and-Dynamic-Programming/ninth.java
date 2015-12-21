import java.util.ArrayList;
import java.util.Arrays;

/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.9
 * Write an algorithm to print all possible ways of arranging eight queens on an 8x8 chess board 
 * so that none of them share the same row, column or diagonal. In this case, "diagonal" means 
 * all diagonals, not just the two that bisect the board.
 */

public class ninth {
	static int size = 8;
	
	ArrayList<String> getNQueensSolutions() {
		int[] columns = new int[8];
		Arrays.fill(columns, -1);
		ArrayList<String> solutions = new ArrayList<>();
		getNQueensSolutions(0, columns, solutions);
		return solutions;
	}
	
	void getNQueensSolutions(int row, int[] columns, ArrayList<String> output) {
		if(row == size)
			output.add(Arrays.toString(columns));
		else {
			for(int column = 0 ; column < size ; column++) {
				if(isValid(row, column, columns)) {
					columns[row] = column;
					getNQueensSolutions(row+1, columns, output);
				}
			}
		}
	}
	
	boolean isValid(int row, int column, int[] columns) {
		for(int row2 = 0; row2 < row; row2++) {
			int column2 = columns[row2];
			if(column == column2) {
				return false;
			}
			
			// check for diagonals.. if row distance and column distance are the same, 
			// then two queens share a diagonal. 			
			int column_dist = Math.abs(column2 - column);
			int row_dist = row - row2;
			
			if(column_dist == row_dist)
				return false;
		}
		return true;
	}
	
	public static void main(String[] a) {
		ninth test = new ninth();
		ArrayList<String> solutions = test.getNQueensSolutions();
		System.out.println(solutions);
		System.out.println(solutions.size());
	}
}
