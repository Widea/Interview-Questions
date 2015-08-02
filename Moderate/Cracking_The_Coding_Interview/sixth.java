package moderate;
/*
 * Cracking the coding interview 
 * Chapter: Moderate
 * Solution: 17.6
 * Given an array of integers, write a method to find indices m and n such that if you sorted
 * elements m through n,the entire array would be sorted. Minimize n - m (that is, find the smallest such sequence).
 * Author: Viveka Aggarwal
 */

public class sixth {
	public static int findLeft(int[] arr) {
		for(int i = 0; i < arr.length - 1 ; i++) {
			if(arr[i] > arr[i+1]) {
				return i;
			}
		}
		return arr.length - 1;
	}
	
	public static int findRight(int[] arr) {
		for(int i = arr.length - 2; i >= 0 ; i--) {
			if(arr[i+1] < arr[i]) {
				return i+1;
			}
		}
		return 0;
	}
	
	public static int shrinkRight(int[] arr, int maxI, int startR) {
		int max = arr[maxI];
		for(int i = startR ; i < arr.length ; i++) {
			if(arr[i] >= max)
				return i-1;
		}
		return arr.length - 1;
	}
	
	public static int shrinkLeft(int[] arr, int minI, int startL) {
		int min = arr[minI];
		for(int i = startL - 1 ; i >= 0 ; i--) {
			if(arr[i] <= min)
				return i+1;
		}
		return 0;
	}
	
	public static void findUnsortedSequence(int[] arr) {
		int left = findLeft(arr);
		int right = findRight(arr);
				
		int minI = left + 1;
		if(minI >= arr.length - 1 )
			return;
		
		int maxI = right - 1;
		for (int i = left; i <= right; i++) {
			if (arr[i] <= arr[minI]) 
				minI = i; 
			if (arr[i] >= arr[maxI]) 
				maxI = i;
		}
		
		System.out.println(minI + " : " +maxI);
	int leftI = shrinkLeft(arr, minI, left);
	int rightI = shrinkRight(arr, maxI, right);
	System.out.println("From: " +leftI + " to: " +rightI);
	}
	
	public static void main(String[] args) {
		int[] test = {1, 2, 4, 7, 10, 11, 8, 12, 5, 7, 16, 18, 19};
		findUnsortedSequence(test);
	}
}