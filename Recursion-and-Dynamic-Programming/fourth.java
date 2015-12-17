import java.util.ArrayList;
/* Cracking the coding interview
 * Chapter : Recursion-and-Dynamic-Programming
 * Question: 9.4
 * Write a method to return all subsets of a set.
 */

public class fourth {
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list) {
		if(list == null)
			return null;
		
		return getSubsets(list, 0);
	}
	
	ArrayList<ArrayList<Integer>> allSubSets;
	
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list, int index) {		
		if(index == list.size()) {
			allSubSets = new ArrayList<ArrayList<Integer>>();
			allSubSets.add(new ArrayList<>());
		} else {
			getSubsets(list, index + 1);
			int curr = list.get(index);
			ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> set : allSubSets) {
				ArrayList<Integer> tempSet = new ArrayList<Integer>();
				tempSet.addAll(set);
				tempSet.add(curr);
				moreSubSets.add(tempSet);
			}
			allSubSets.addAll(moreSubSets);
		}
		return allSubSets;
	}
	
	public static void main(String[] a) {
		fourth test = new fourth();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		ArrayList<ArrayList<Integer>> out = test.getSubsets(list);
		System.out.println(out.toString());
		
	}
}
