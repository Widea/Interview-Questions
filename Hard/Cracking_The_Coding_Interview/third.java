package Hard;

/*
 * Cracking the coding interview 
 * Chapter: Hard
 * Solution: 18.3
 * Write a method to randomly generate a set of m integers from an array of size n.
 * Each element must have equal probability of being chosen.
 * Author: Viveka Aggarwal
 */

public class third {
	public static int random(int i , int j) {
		return i + (int)(Math.random() * (Math.abs(j - i) + 1));
	}
	
	public static int[] shuffle(int[] arr, int size) {
		if(size > arr.length)
			size = arr.length;
		int[] out = new int[size];
		for(int i = 0 ; i < size ; i++) {
			out[i] = arr[i];
		}
		for(int i = size ; i < arr.length ; i++) {
			int k = random(0, i);
			if(k < size) {
				out[k] = arr[i];
			}	
		}
		return out;
	}
	
	public static void main(String[] args) {
		int[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		System.out.println("Initial set: ");
		for(int i : set)
			System.out.print(i + " ");
		
		int[] out = shuffle(set, 7);
		
		System.out.println();
		System.out.println("Shuffled deck: ");
		for(int i : out)
			System.out.print(i + " ");
	}
}