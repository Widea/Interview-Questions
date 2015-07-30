/* Cracking the coding interview
 * Chapter : Searching and Sorting
 * Question: 11.5
 * Given a sorted array of strings which is interspersed with empty strings,
 * write a method to find the location of a given string.
 * EXAMPLE
 * Input: find "ball" in {"at", "", "", "", "ball", "", "", "car", "", "", "dog"}
 * Output: 4
 * Author: Viveka Aggarwal
 */

public class fifth {
	public static int search(String[] a, int left, int right, String x){
		if(left > right)
			return -1;
		
		int mid = (left + right)/2;
		
		if(a[mid].isEmpty()) {
			int l = mid - 1;
			int r = mid + 1;
			while(true) {
				if(l < left && r > right)
					return -1;
				if(r <= right && !a[r].isEmpty()){
					mid = r;
					break;
				} 
				if(l >= left && !a[l].isEmpty()){
					mid = l;
					break;
				}
				l--;
				r++;
			}
		}
		
		if(a[mid].equals(x))
			return mid;
		else if(a[mid].compareTo(x) < 0)
			return search(a, mid+1, right, x);
		else 
			return search(a, left, mid-1, x);
		
	}
	
	public static int search(String[] a, String search) {
		if(a == null || search == null || search.isEmpty())
			return -1;
		return search(a, 0, a.length - 1, search);
	}
	
	public static void main(String[] args) {
		String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dog"};
		System.out.println(search(input,"ball"));
	}
}
