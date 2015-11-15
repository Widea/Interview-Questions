import java.util.Arrays;
import java.util.Comparator;

// Program to sort a given String array based on the lengths of the strings

public class SortStringBasedOnLength implements Comparator<String>{

	@Override
	public int compare(String a, String b) {
		
		if(a.length() == b.length())
			return 0;
		else if(a.length() > b.length())
			return 1;
		else return -1;
	}
	
	public static void main(String[] a) {
		String[] test = {"cat","aaaaaaaaaa","cata","hekcdjd","cataa","123456890543","cataaa","cataaaa"};
		for(String s : test)
			System.out.println(s + " ");
		System.out.println();
		Arrays.sort(test, new SortStringBasedOnLength());
		for(String s : test)
			System.out.println(s + " ");
	}
	
}
