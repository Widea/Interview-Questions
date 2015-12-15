// Program to find if two words, differ by just one character. 

public class EditDistance {
	
	boolean editDistanceAway(String first, String sec) {
		boolean isDifferent = false;
		
		for(int i = 0; i < first.length() ; i++) {
			if(first.charAt(i) != sec.charAt(i)) {
				if(isDifferent == true)
					return false;
				isDifferent = true;
			}
		}
		
		return true;
	}
	
	boolean editDistanceAdd(String first, String sec) {
		int i = 0, j = 0;
		
		while(i < first.length() && j < sec.length()) {
			if(first.charAt(i) != sec.charAt(j)) {
				if(i != j)
					return false;
				i++;
			} else {
				i++; j++;
			}
		}
		
		return true;
	}
	
	boolean editDistance(String first, String second) {
		if(first == null || second == null)
			return false;
		if(first.length() == second.length()) 
			return editDistanceAway(first, second);
		
		if(first.length() - second.length() == 1) 
			return editDistanceAdd(first, second);
		
		if(first.length() - second.length() == -1) 
			return editDistanceAdd(second, first);
		
		return false;
	}
	
	public static void main(String[] a) {
		EditDistance test = new EditDistance();
		System.out.println(test.editDistance("Helpl", "Hell"));
		System.out.println(test.editDistance("Hello", "Helli"));
	}
}
