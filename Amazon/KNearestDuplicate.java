import java.util.Scanner;

/*
 * Write a function that determines whether a two dimensional array contains duplicate values within k indices of each other.
 * The first line of input will be a number indicating how many rows are in the matrix. 
 * This will be followed by lines of input one for each row of the matrix each row will contain the same number of columns 
 * with each column separated by a space. Following the matrix will be a single line of input containing a number 
 * indicating the k value.
 * Output should be ‘YES’ or ‘NO’
 * Example:
 * 4
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 3
 * 
 * Output: No
 */

 public class KNearestDuplicate {
	 static String hasDuplicates(int[][] input, int n, int k) {
		 if(input == null)
			 return "NO";
		 
		 for(int i = 0 ; i < n ; i++) {
			 for(int j = 0; j < n ; j++) {
				 if(check(input, i, j, n, k))
					 return "YES";
			 }
		 }
		 return "NO";
	 }
	 
	 static boolean check(int[][] input, int i, int j, int n, int k) {
		 int value = input[i][j];
		 
		int i_min = (i - k) < 0 ? 0 : i - k;
		int j_min = (j - k) < 0 ? 0 : j - k;
		int i_max = (i + k) < n ? i+k : n-1;
		int j_max = (j + k) < n ? j+k : n-1;
		 
		
		 while(i_min <= i_max) {
			if(input[i_min][j] == value && i_min != i)
				return true;
			i_min++;
		 }
		 
		 while(j_min <= j_max) {
				if(input[i][j_min] == value && j_min != j)
					return true;
				j_min++;
			 }
		 
		 return false;
	 } 
	 
	 public static void main(String[] a) {
		 Scanner in = new Scanner(System.in);
		 int n = in.nextInt();
		 int[][] mat = new int[n][n];
		 
		 for(int i = 0 ; i < n ; i++) {
			 for(int j = 0 ; j < n ; j++) {
				 mat[i][j] = in.nextInt();
			 }
		 }
		 
		 int k = in.nextInt();
		 in.close();
		 System.out.println(hasDuplicates(mat, n, k));
	 }
 } 
