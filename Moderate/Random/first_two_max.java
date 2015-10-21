// program to find the highest and the second highest value in a given array

public class first_two_max {
	
	static void findMaxes(int[] array) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		
		for(int i : array) {
			if(i > max1) {
				max2 = max1;
				max1 = i;
			} else if(i > max2) {
				max2 = i;
			}
		}
		
		System.out.println("The highest value is: "+max1);
		System.out.println("The second highest value is: "+max2);
	}
	
	public static void main(String[] args) {
		int inputArray[] = {1,2,33,12,454,66,32,789,543,99,25,252};
		findMaxes(inputArray);
	}
}
