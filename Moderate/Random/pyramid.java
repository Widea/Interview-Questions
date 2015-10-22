//program to print a pyramid of stars

public class pyramid {
	
	public static void main(String[] args) {
		for(int i = 0; i < 8 ; i++) {
			// creating spaces before placing the actual values
			// The spacing reduces by 1 each time. 
			for(int j = 0 ; j < 8-i ; j++) {
				System.out.print(" ");
			}
			for(int k = 0 ; k <= i ; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
