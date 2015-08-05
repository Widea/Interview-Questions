package Hard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Cracking the coding interview 
 * Chapter: Hard
 * Solution: 18.5
 * You have a large text file containing words. Given any two words, find the shortest
 * distance (in terms of number of words) between them in the file. If the operation
 * will be repeated many times for the same file (but different pairs of words), can you
 * optimize your solution?
 * Author: Viveka Aggarwal
 */

public class fifth {
	public static int getDistance(String w1, String w2, ArrayList<String> file) {
		int p1 = -1;
		int p2 = -1;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < file.size() ; i++) {
			String current = file.get(i);
			if(current.equals(w1)) {
				p1 = i;
				int dist = p1 - p2;	
				if(dist < min && p2 != -1)
					min = dist;
			} else if(current.equals(w2)) {
				p2 = i;
				int dist = p2 - p1;	
				if(dist < min && p1 != -1)
					min = dist;
			}
		}
		return min;
	}
	
	public static void main(String[] a) throws FileNotFoundException {
		
		ArrayList<String> fileReader = new ArrayList<String>();
		
		Scanner in = new Scanner(System.in);
		String filePath;
		System.out.println("Enter fil name with path: ");
		filePath = in.nextLine();
		
		File file = new File(filePath);
		Scanner input = null;
			input = new Scanner(file);
		while(input.hasNext()) {
			fileReader.add(input.next());
		}
		
		System.out.println(getDistance("my", "abc", fileReader));
		input.close();
	}
}