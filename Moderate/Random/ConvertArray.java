/* Given an array [a1, a2, ..., aN, b1, b2, ..., bN, c1, c2, ..., cN] 
 * convert it to [a1, b1, c1, a2, b2, c2, ..., aN, bN, cN] in-place using constant extra space.
 * Author : Viveka Aggarwal
 */

public class ConvertArray {
	
	static int getActualIndex(int i, int len) {
		return ((i % 3) * len + i/3);
	}
	
	public static void convert(int[] arr) {
		if(arr.length % 3 != 0 ) {
			System.out.println("Array cannot be divided into three equal parts");
			return;
		}
		for(int i = 0 ; i < arr.length ; i++) {
				int originalIndex = getActualIndex(i, arr.length/3);
				while (originalIndex < i) {
					originalIndex = getActualIndex(originalIndex, arr.length/3);
				}
				int temp = arr[i];
				arr[i] = arr[originalIndex];
				arr[originalIndex] = temp;
			}
	
		for(int x : arr) 
			System.out.print(x + " ");
		
	}
	
	public static void main(String[] args) {
		int[] test1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		convert(test1);
	}
}
