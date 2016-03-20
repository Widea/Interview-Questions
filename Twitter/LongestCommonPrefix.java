// Given a list of strings, write a program to find the longest common prefix.
// Source: Glassdoor

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] list) {
       if(list == null || list.length == 0)
    	   return null;
       
       String longest_prefix = list[0];
       
       for(int i = 1 ; i < list.length ; i++) {
    	   while(!list[i].startsWith(longest_prefix)) {
    		   longest_prefix = longest_prefix.substring(0, longest_prefix.length() - 1);
    	   }
       }
       
       return longest_prefix;
    }
	
	public static void main(String[] a) {
		System.out.println(longestCommonPrefix(new String[] {"Apple", "App","Apppp", "Apphel"}));
	}
}
