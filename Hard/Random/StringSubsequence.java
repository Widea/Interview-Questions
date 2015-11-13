// Program to find all possible subsequences of a string and print it in lexicographical order

import java.io.*;
import java.util.*;

public class StringSubsequences {
    
	static String[] buildSubsets(String str) {
         Stack<String> stack = new Stack<String>();
    	 List<String> list = new ArrayList<String>();
         int len = str.length();
         for(int i = 0 ; i < len ; i++) {
        	 String temp = ""+str.charAt(i);
        	 stack.push(temp);
         }
         while(!stack.isEmpty()) {       	
        	 String temp = stack.pop();
        	 if(temp.length() > str.length()) {
        		 while(!stack.isEmpty())
        			 list.add(stack.pop());
        		 break;
        	 }
        	 list.add(temp);
        	 int pos = str.indexOf(temp.charAt(temp.length()-1));
        	 for(int i = pos+1; i < len ; i++) {
        		 stack.push(temp + str.charAt(i));
        	 }
         }
       
         Collections.sort(list);
        String[] stockArr = new String[list.size()];
        
        stockArr = list.toArray(stockArr);
        return stockArr;
    }
	
	  public static void main(String[] args) throws IOException{
	        String[] in = buildSubsets("bac");
	        for(String i : in)
	        	System.out.print(i + " ");
	    }
	}
