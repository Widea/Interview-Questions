// Program to merge two sorted lists.

public class MergeSortedLists {
	
	static int[] mergeLists(int[] a, int[] b) {
		if(a == null && b == null)
			return new int[0];
		
		if(a == null || a.length == 0)
			return b;
		
		if(b == null || b.length == 0)
			return a;
		
		int l1 = a.length;
		int l2 = b.length;
		
		int[] c = new int[l1+l2];
		int a1 = 0, b1 = 0, c1 = 0 ;
		
		while(a1 < l1 && b1 < l2) {
			if(a[a1] <= b[b1]) {
				c[c1] = a[a1];
				a1++;
			}
			else {
				c[c1] = b[b1];
				b1++;
			}
			c1++;
			
			if(a1 == l1) {
				while(b1 < l2) {
					c[c1] = b[b1];
					c1++;
					b1++;
				}
			}
			
			if(b1 == l2) {
				while(a1 < l1) {
					c[c1] = a[a1];
					c1++;
					a1++;
				}
			}
		}
		
		return c;
		
	}
	
	public static void main(String[] a) {
		int[] first = {1,3,5,7,21};
		int[] second = {0,2,4,6,8,10,11,12,15};
		int out[] = mergeLists(first, second);
		int out1[] = mergeLists(null, null);

		for(int i : out) {
			System.out.print(i + "  ");
		}
		
		for(int i : out1) {
			System.out.print(i + "  ");
		}
		
	}
}
