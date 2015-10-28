/* Program to get the power set of a given set
 * For example: For the set [1,2,3]
 * The power set would be:
 * {[],[1],[2],[3],[1,2],[2,3],[1,3],[1,2,3]}
 */

public class PowerSet {
	static void getPowerSet(char[] in) {
		int inSize = in.length;
		int outSize = (int) Math.pow(2, inSize);
		
		for(int i = 0 ; i < outSize ; i++) {
			System.out.print("Set " +i + ": ");
			for(int j = 0 ; j < inSize ; j++) {
				if((i & (1 << j)) == 0) {
					System.out.print(in[j]+" " );
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		char[] input = {'a','b','c','d'};
		getPowerSet(input);
	}
}
