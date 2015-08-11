
/* 
 * CareerCup Interview Question - Google
 * Question -> Check if two integers are equal without using any comparison operators
 *
 */

public class compareNumbers {
	static boolean Compare(int a, int b) {
		switch(a - b) {
		case 0: return true;
		default: return false;
		}
	}

	public static void main(String[] a) {
		System.out.println(Compare(2, -2));
		System.out.println(Compare(2, 2));
		System.out.println(Compare(82, 24));
	}
}
