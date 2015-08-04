package Hard;

/*
 * Cracking the coding interview 
 * Chapter: Hard
 * Solution: 18.2
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle—in other words, 
 * each of the 52! permutations of the deck has to be equally likely. Assume that you are 
 * given a random number generator which is perfect.
 * Author: Viveka Aggarwal
 */

public class second {
	public static int random(int i , int j) {
		return i + (int)(Math.random() * (Math.abs(j - i) + 1));
	}
	
	public static void shuffle(int[] cards, int num) {		
		for(int i = 0 ; i < num ; i++) {
			int k = random(0, i);
			int temp = cards[i];
			cards[i] = cards[k];
			cards[k] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		System.out.println("Initial deck: ");
		for(int i : cards)
			System.out.print(i + " ");
		shuffle(cards, cards.length);
		System.out.println();
		System.out.println("Shuffled deck: ");
		for(int i : cards)
			System.out.print(i + " ");
	}
}