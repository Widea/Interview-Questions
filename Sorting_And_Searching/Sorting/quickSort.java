// program to implement quick sort on an input integer array

import java.util.Arrays;
import java.util.Scanner;

public class quickSort {

	public static int partitionList(int[] A, int start , int end)
	{
		// set pointers for denoting array positions 
		int i = start, j = end;
		
		// factor for swapping elements
		int pivot = A[(i+j)/2];		
		
		// for swapping elements
		int temp;
		
		while(i <= j)
		{
			// elements before the pivot should be smaller
			while(A[i] < pivot)
			{
				i++;
			}
			
			// elements after the pivot value should be larger
			while(A[j] > pivot)
			{
				j--;
			}
			
			// swap elements if i(th) value is greater than pivot and j(th) value is smaller than pivot.  
			if(i <= j)
			{
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				
				i++;
				j--;
			}
		}
		return i;
	}
	
	public static void sort(int[] inputArray, int start, int end )
	{
		// partition list based on the pivot position
		int index = partitionList(inputArray, start, end);
		
		if(start < index - 1)
		{
			sort(inputArray, start, index - 1);
		}
		
		if(end > index)
		{
			sort(inputArray, index, end);
		}
	}
	
	public static void main(String[] args)
	{	
		// input scanner
		Scanner in = new Scanner(System.in);
		
		// get the array size
		System.out.println("Enter the array size: ");
		int size = in.nextInt();
		
		int[] array = new int[size];
		
		// get the array values		
		System.out.println("*** Enter the array values ***");
		
		for(int i = 0; i < size ; i++)
		{
			System.out.print("Enter the element value at position " +(i+1) + " : " );
			array[i] = in.nextInt();
			System.out.println();
		}
		
		in.close();	
		
		System.out.println("Input array : " + Arrays.toString(array));
		
		// sort and display the entered array values
		sort(array, 0 , size-1);
		System.out.println("Sorted array : " + Arrays.toString(array));
		
		
	}
}