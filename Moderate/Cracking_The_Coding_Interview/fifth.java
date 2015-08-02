package moderate;

import java.util.Random;
/*
 * Cracking the coding interview 
 * Chapter: Moderate
 * Solution: 17.5
 * The Game of Master Mind is played as follows:
 * The computer has four slots, and each slot will contain a ball that is red (R), yellow (Y), green (C) or blue (B). 
 * For example, the computer might have RGGB (Slot # 1 is red, Slots #2 and #3 are green, Slot #4 is blue).
 * You, the user, are trying to guess the solution. You might, for example, guess YRGB.
 * When you guess the correct color for the correct slot, you get a "hit." 
 * If you guess a color that exists but is in the wrong slot, you get a "pseudo-hit." 
 * Note that a slot that is a hit can never count as a pseudo-hit.
 * For example,if the actual solution is RGBY and you guess GGRR, you have one hit and one pseudo-hit.
 * Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
 * Author: Viveka Aggarwal
 */

public class fifth {
		public static int code(char c) {
			switch (c) {
			case 'B':
				return 0;
			case 'G':
				return 1;
			case 'R':
				return 2;
			case 'Y':
				return 3;
			default:
				return -1;
			}
		}
				
		public static void result(String guess, String solution) {
			int hit = 0, pHit = 0;
			int[] frequency = new int[4];
			
			for(int i = 0 ; i < guess.length() ; i++) {
				if(guess.charAt(i) == solution.charAt(i))
					hit++;
				else {
					int index = code(solution.charAt(i));
					frequency[index]++;
				}
			}
			
			for(int i = 0 ; i < guess.length() ; i++) {
				int c = code(guess.charAt(i));
				if(c >= 0 && frequency[c] > 0 && guess.charAt(i) != solution.charAt(i)) {
					pHit++; frequency[c]--;
				}
			}
			
			System.out.println("(" + hit + " hits, " + pHit + " pseudo hits)");
		}
		
		public static char letterFromCode(int k) {
			switch (k) {
			case 0:
				return 'B';
			case 1:
				return 'G';
			case 2:
				return 'R';
			case 3:
				return 'Y';
			default:
				return '0';
			}		
		}
				
		public static String random() {
			int length = 4;
			char[] str = new char[length];
			Random generator = new Random();
			
			for (int i = 0; i < length; i++) {
				// Generate a random number between 0 to 4.
				int v = generator.nextInt(4);
				char c = letterFromCode(v);
				str[i] = c;
			}			
			return String.valueOf(str);
		}
		
		public static void main(String[] args) {
			String guess = random();
			System.out.println("Guess String: " +guess);
			String solution = random();
			System.out.println("Actaul String: " +solution);
			result(guess, solution);
		}
		
}