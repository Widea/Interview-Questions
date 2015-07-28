package sortingAndSearching;

/*
 * Cracking the coding interview 
 * Chapter: Sorting and Searching
 * Solution: 11.1
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order.
 * Author: Viveka Aggarwal
 */

public class first {
	
	static void mergeLists(int[] A, int[] B, int Elem_A) {
		int a = Elem_A - 1;
		int b = B.length - 1;
		int x = A.length - 1;
		
		while(a >= 0 && b >= 0) {
			if(A[a] >= B[b]){
				A[x] = A[a];
				a--;
			}
			else {
				A[x] = B[b];
				b--;
			}
			x--;
			
			if(b < 0) {
				while(a >= 0) {
					A[x] = A[a];
					a--; x--;
				}
			}
			
			if(a < 0) {
				while(b >= 0) {
					A[x] = B[b];
					b--; x--;
				}
			}	
		}
	}
	
	static void printList(int[] A) {
		System.out.println();
		System.out.println("Printing list . . .");
		for(int i :A) {
			System.out.print(i + "  ");
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0,0};
		int[] b = {1,2, 4, 5, 6, 7, 7};
		mergeLists(a, b, 8);
		printList(a);
	}
}