/*
* Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
* Print all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and 
* x is a element of given BST.
*/

public class PrintInRange {
  void printNodesBetweenRange(node start, int k1, int k2) {
    if(start == null)
		return;

	  if(start.value < k1) {
		    printNodesBetweenRange(start.right, k1, k2); 
    } else if(start.value > k2) {
	      printNodesBetweenRange(start.left, k1, k2); 
    } else {
		    System.out.print(start.value + "  ");
		    printNodesBetweenRange(start.right, k1, k2);
		    printNodesBetweenRange(start.left, k1, k2);
    }
  }
}
