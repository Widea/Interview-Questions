// Write a program to find the common elements between two sorted arrays
// Source: Glassdoor

public class FindCommonElements {
	static void getCommonElements(int[] A, int[] B) {
		if(A == null || B == null || A.length == 0 || B.length == 0) {
			System.out.println("No matching elements");
		}
		
		int i = 0, j = 0;
	
		while(i < A.length && j < B.length) {
			if(A[i] < B[j]) {
				i++;
			} else if(A[i] > B[j]) {
				j++;
			} else {
				System.out.print(A[i] + " ");
				i++; j++;
			}
		}
	}
	
	public static void main(String[] a) {
		getCommonElements(new int[] {1, 2, 3, 4, 5, 6, 7},new int[] {6, 7, 8, 9, 10});
	}
}
