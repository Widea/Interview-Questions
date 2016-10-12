import java.util.*;
import java.util.HashMap;

// find the number and indices of anagrams of string a in string b.

public class Anagram
{ 
	public static List<Integer> getAnagramIndices(String first, String second) 
	{
	 List<Integer> rList = new ArrayList<Integer>();
	
	  Map<Character, Integer> map = new HashMap<Character, Integer>();
	    
	  	for(Character c : second.toCharArray())
	  	{	
	    	if(!map.containsKey(c))
	    	{
	    		map.put(c, 1);
	    	}
	    } 
	  	 
    int len = first.length();
 
    char[] secondArray = second.toCharArray();
    Arrays.sort(secondArray);
    
    for(int j = 0 ; j < len - second.length() ; j++)
    {   
    	String sub = first.substring(j, j + second.length());
    	boolean check = true;

    	for(Character c : sub.toCharArray())
	    {   	
	    	if(!map.containsKey(c))
	    	{
	    		check = false;
	    		break;
	    	}
	    }
    	if(check == true)
    	{		
    		check = anagramChecker(secondArray, sub.toCharArray());
    	}
    	
    	if(check)
    	{
    		rList.add(j);
    	}
    }
    return rList;
	}
	
	static boolean anagramChecker(char[] a, char[] b)
	{
		Arrays.sort(b);
		
		return new String(a).equals(new String(b));
	}
	
	public static void main(String[] a)
	{
		
		List<Integer> in = getAnagramIndices("abdcghbaabcdigeyufhuieabdcjedfaddchhhacdb", "abdc");
		System.out.println(in);
	}
}
