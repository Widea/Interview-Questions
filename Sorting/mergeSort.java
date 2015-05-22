// Implementing merge sort on an array of integers.
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort 
{
    public static void main(String[] args) throws IOException
    {	
    	Scanner inputScanner = new Scanner(System.in);
    	System.out.println("Enter array length: ");
        int arraySize = inputScanner.nextInt();
        int[] inputArray = new int[arraySize];
        
        for (int i = 0; i < arraySize; i++) 
        {
          System.out.print("Enter value for index " +(i+1) +": ");
        	inputArray[i] = inputScanner.nextInt();
        	System.out.println();
        }
        
        mergeSort(inputArray);
        System.out.println("The sorted array is: ");        
        
        for (int j = 0; j < inputArray.length; j++) 
            System.out.println(inputArray[j]);
                
        inputScanner.close();
    }

    static void mergeSort(int[] A) 
    {
        if (A.length > 1) 
        {
            int q = A.length/2;
            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A,q,A.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(A,leftArray,rightArray);
        }
    }

    static void merge(int[] a, int[] l, int[] r) 
    {
        int i,li,ri;
        i = li = ri = 0;
        while ( i < a.length ) 
        {
            while ((li < l.length) && (ri < r.length)) 
            {
                if (l[li] < r[ri]) 
                {
                    a[i] = l[li];
                    li++;
                }
                else 
                {
                    a[i] = r[ri];
                    ri++;
                }
                i++;
            }            
                if (li >= l.length) 
                {
                    while (ri < r.length) 
                    {
                        a[i] = r[ri];
                       i++;
                        ri++;
                    }
                }
                if (ri >= r.length) 
                {
                    while (li < l.length) 
                    {
                        a[i] = l[li];
                        li++;
                       i++;
                    }
                }               
        }
    }

}
