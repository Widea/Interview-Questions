import java.util.Scanner;

/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.3
 * A magic index in an array A[l...n-l] is defined to be an index such thatA[i] = i. 
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP: What if the values are not distinct?
 * Author : Viveka Aggarwal
 */

public class third {
	int magicIndexForDistinctIntegersArray(int[] array, boolean isDistinct) {
		if(array == null || array.length == 0)
			return -1;
		
		if(isDistinct)
			return magicIndexForDistinctIntegersArray(array, 0, array.length-1);
		return magicIndexForNonDistinctIntegersArray(array, 0, array.length-1);
	}
	
	int magicIndexForDistinctIntegersArray(int[] array, int start, int end) {		
		if(end < start || start < 0 || end >= array.length) {
			// No magic index
			return -1;
		}
		
		int mid = (start + end)/2;
		
		if(array[mid] == mid) {
			return mid;
		} else if(array[mid] > mid) {
			// Move to the first half of array
			return magicIndexForDistinctIntegersArray(array, start, mid - 1);
		} else
			// Move to the second half of array
			return magicIndexForDistinctIntegersArray(array, mid + 1, end);
 	}
	
	int magicIndexForNonDistinctIntegersArray(int[] array, int start, int end) {
		if(end < start || start < 0 || end >= array.length) {
			// No magic index
			return -1;
		}
		
		int mid = (start + end)/2;
		int midVal = array[mid];
		
		if(mid == midVal)
			return mid;
		
		// Searching the first half of the array
		int leftIndex = Math.min(mid - 1, midVal);
		int left = magicIndexForNonDistinctIntegersArray(array, start, leftIndex);
		
		if(left >= 0)
			return left;
		
		int rightIndex = Math.max(mid + 1, midVal);
		int right = magicIndexForNonDistinctIntegersArray(array, rightIndex, end); 

		return right;
	}
	
	public static void main(String[] a) {
		third test = new third();
		
		int[] A = {-2,1,4,6,7,8};
		int[] B = {1,2,3,3,5,6};
		int[] C = {-2,-1,-4,6,7,8};
		
		System.out.println(test.magicIndexForDistinctIntegersArray(A, true));
		System.out.println(test.magicIndexForDistinctIntegersArray(C, true));
		System.out.println(test.magicIndexForDistinctIntegersArray(B, false));
	}
}
