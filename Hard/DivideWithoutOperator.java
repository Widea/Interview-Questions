Reference : Hemant : https://stackoverflow.com/questions/5386377/division-without-using

// Program to implement long division or simply division
// without using the '/' operator. 

public class DivisionWithoutOperator {
	
	static int divide(int denom, int num) {
		    int current = 1;
		    
		    // This step is required to find the biggest current number which can be
		    // divided with the number safely.
		    while (denom <= num) {
		        current <<= 1;
		        denom <<= 1;
		    }
		    
		    // Since we may have increased the denominator more than num
		    // thus we need to go back one shift, and same would apply for current.
		    denom >>= 1;
		    current >>= 1;
		    int answer = 0;
		    // Now deal with the smaller number.
		    while (current != 0) {
		        if (num >= denom) {
		            num -= denom;
		            answer |= current;
		        }
		        current >>= 1;
		        denom >>= 1;
		    }
		    return answer;
		}
	
	
	public static void main(String[] args) {
		System.out.println(divide(2,4));
		System.out.println(divide(2,8));
		System.out.println(divide(3,56));
		System.out.println(divide(3,57));
	}
}
