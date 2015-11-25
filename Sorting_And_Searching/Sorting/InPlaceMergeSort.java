// Not my code 
// Reference: http://penguin.ewu.edu/class/cscd300/Topic/AdvSorting/MergeSorts/MergeSort.java

import java.util.*;

/** Implements the recursive merge sort algorithm. In this version, copies
 *  of the subtables are made, sorted, and then merged.
 *  @author Koffman and Wolfgang
 */

public class MergeSort {
  /** Sort the array using the merge sort algorithm.
      pre: table contains Comparable objects.
      post: table is sorted.
      @param table The array to be sorted
   */
  public static < T
      extends Comparable < T >> void sort(T[] table)
  { // A table with one element is sorted already.
    if (table.length > 1)
    { // Split table into halves.
      int halfSize = table.length / 2;
      T[] leftTable = (T[])new Comparable[halfSize];
      T[] rightTable =
          (T[])new Comparable[table.length - halfSize];
      System.arraycopy(table, 0, leftTable, 0, halfSize);
      System.arraycopy(table, halfSize, rightTable, 0,
                       table.length - halfSize);

      // Sort the halves.
      sort(leftTable);
      sort(rightTable);

      // Merge the halves.
      merge(table, leftTable, rightTable);
    }
  }

  /** Merge two sequences.
       pre: leftSequence and rightSequence are sorted.
       post: outputSequence is the merged result and is sorted.
       @param outputSequence The destination
       @param leftSequence The left input
       @param rightSequence The right input
   */
  private static < T
      extends Comparable < T >> void merge(T[] outputSequence,
                                           T[] leftSequence,
                                           T[] rightSequence) {
    int i = 0; // Index into the left input sequence.
    int j = 0; // Index into the right input sequence.
    int k = 0; // Index into the output sequence.

    // While there is data in both input sequences
    while (i < leftSequence.length && j < rightSequence.length) {
      // Find the smaller and
      // insert it into the output sequence.
      if (leftSequence[i].compareTo(rightSequence[j]) <= 0) {
        outputSequence[k++] = leftSequence[i++];
      }
      else {
        outputSequence[k++] = rightSequence[j++];
      }
    }
    // assert: one of the sequences has more items to copy.
    // Copy remaining input from left sequence into the output.
    while (i < leftSequence.length) {
      outputSequence[k++] = leftSequence[i++];
    }
    // Copy remaining input from right sequence into output.
    while (j < rightSequence.length) {
      outputSequence[k++] = rightSequence[j++];
    }
  }

/**
 * In-Place Merge Sort.
 *
 * Building on the algorithm core found in
 * http://www.cs.ubc.ca/~harrison/Java/MergeSortAlgorithm.java.html
 */
   public static void inPlaceSort ( Comparable[] x )
   {  inPlaceSort (x, 0, x.length-1);  }

   private static void inPlaceSort ( Comparable[] x, int first, int last )
   {
      int mid, lt, rt;
      Comparable tmp;

      if ( first >= last ) return;

      mid = (first + last) / 2;

      inPlaceSort (x, first, mid);
      inPlaceSort (x, mid+1, last);

      lt = first;  rt = mid+1;
      // One extra check:  can we SKIP the merge?
      if ( x[mid].compareTo(x[rt]) <= 0 )
         return;

      while (lt <= mid && rt <= last)
      {
         // Select from left:  no change, just advance lt
         if ( x[lt].compareTo(x[rt]) <= 0 )
            lt++;
         // Select from right:  rotate [lt..rt] and correct
         else
         {
            tmp = x[rt];     // Will move to [lt]
            System.arraycopy(x, lt, x, lt+1, rt-lt);
            x[lt] = tmp;
            // EVERYTHING has moved up by one
            lt++;  mid++;  rt++;
         }
      }
      // Whatever remains in [rt..last] is in place
   }
}
