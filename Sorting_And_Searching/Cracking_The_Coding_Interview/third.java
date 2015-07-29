package sortingAndSearching;

/*
 * Cracking the coding interview 
 * Chapter: Sorting and Searching
 * Solution: 11.3
 * Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in the array. You may assume that the array was
 * originally sorted in increasing order.
 * Author: Viveka Aggarwal
 */

public class third {
	
	public static int search(int[] a,int start, int end, int x) {
		if(start > end)
			return -1;
		
		int mid = (start + end)/2;
		
		if(a[mid] == x)
			return mid;
		
		if(a[mid] > a[start]) {
			if(x >= a[start] && x <= a[mid])
				return search(a, start, mid -1, x);
			else
				return search(a, mid + 1, end, x);
		}
		
		if(a[mid] < a[end]) {
			if(x >= a[mid] && x <= a[end])
				return search(a, mid + 1, end, x);
			else
				return search(a, start, mid -1, x);
		}
		
		if(a[mid] == a[start]) {
			if(a[mid] != a[end]) {
				return search(a, mid + 1, end, x);
			} else {
				int result = search(a, start, mid -1, x);
				if(result == -1)
					return search(a, start, mid -1, x);
				else
					return result;
			}
		}
		
		return -1;
	}
	
	public static int search(int[] a, int search) {
		return search(a, 0, a.length - 1, search );
	}
	
	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 1, 2, 2, 2, 2 , 2 , 2 };

		System.out.println(search(a, 2));
		System.out.println(search(a, 3));
		System.out.println(search(a, 4));
		System.out.println(search(a, 1));
		System.out.println(search(a, 8));
	}
}