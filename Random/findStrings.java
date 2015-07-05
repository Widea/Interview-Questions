// Generate strings with a specified pattern -- Google
// Source: https://sites.google.com/site/spaceofjameschen/home/string/generate-strings-with-a-specified-pattern----google
/*	Problem:
 *	Given a string pattern of 0s, 1s, and ?s (wild cards), generate all 0-1 strings that match this pattern. 
 *	e.g. 1?00?101 -> [10000101, 10001101, 11000101, 11001101]. 
 *	You can generate the strings in any order that suits you.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class findStrings
{

	static void GenerateStringsWithPattern(String pattern)
	{
		Queue<String> q = new LinkedList<String>();
		
		q.add(pattern);
		while(!q.isEmpty())
		{
			StringBuffer str = new StringBuffer(q.poll());
			int idx = str.indexOf("?");
			if(idx != -1)
			{
	            str.setCharAt(idx, '0');
				q.add(str.toString());
				str.setCharAt(idx, '1');
				q.add(str.toString());
	        }			
	        else
	        {
	            System.out.println(str.toString());
	        }
	    }
	}
			
	
	public static void main(String[] args)
	{
		Vector<String> testCases = new Vector<String>();
	    testCases.add("1000?101");
	    testCases.add("1?00?101");
	    testCases.add("1??0?101");
	    testCases.add("?");
	    testCases.add("??");
	    testCases.add("???");
	    testCases.add("1");
	    testCases.add("101");

	    for(int i = 0; i < testCases.size(); i++)
	    {
	        System.out.println("---------------------------");
	        System.out.println("The pattern is " +testCases.get(i));
	        GenerateStringsWithPattern(testCases.get(i));
	    }
	}
}