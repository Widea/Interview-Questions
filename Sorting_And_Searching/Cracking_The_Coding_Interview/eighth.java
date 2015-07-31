package sortingAndSearching;
/*
 * Cracking the coding interview 
 * Chapter: Sorting and Searching
 * Solution: 11.8
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able to
 * look up the rank of a number x (the number of values less than or equal to x). Implement
 * the data structures and algorithms to support these operations. That is, implement
 * the method track(int x), which is called when each number is generated,
 * and the method getRankOfNumber(int x), which returns the number of values
 * less than or equal to x (not including x itself).
 * Author: Viveka Aggarwal
 */

public class eighth {
		node root;
		
		public eighth() {
			root = null;
		}
		
		public void rank(int x) {
			if(root == null)
				root = new node(x);
			else
				root.insert(x);
		}
		
		public int getRank(int x) {
			return root.getRank(x);
		}
	
	private class node {
		int data;
		int rank;
		node left;
		node right;
		
		node(int data) {
			this.data = data;
			rank = 0;
			left = right = null;
		}
		
		public void insert(int d) {
			if (d <= data) {
				if (left != null) {
					left.insert(d);
				} else {
					left = new node(d);
				}
				rank++;
			} else {
				if (right != null) {
					right.insert(d);
				} else {
					right = new node(d);
				}
			}
		}
		
		public int getRank(int d) {
			if (d == data) {
				return rank;
			} else if (d < data) {
				if (left == null) {
					return -1;
				} else {
					return left.getRank(d);
				}
			} else {
				int right_rank = right == null ? -1 : right.getRank(d);
				if (right_rank == -1) {
					return -1;
				} else {
					return rank + 1 + right_rank;
				}
			}
		}
		
	}
	
	public static void main(String[] a) {
		eighth DS = new eighth();
		int[] input = {21, 3, 18, 92, 45, 53, 35, 65, 72, 28, 29, 10};
		
		for(int i : input) {
			DS.rank(i);
		}
		
		for(int i : input) {
			System.out.println("The rank of " +i + " is: " +DS.getRank(i));
		}
	}
}