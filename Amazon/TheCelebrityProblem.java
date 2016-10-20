/**
 * Question: In a party of N people, only one person is known to everyone. 
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. 
 * We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.  
 *
 * Source: Glassdoor.
 */
 
package TheCelebrityProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * @author widea
 *
 */
public class TheCelebrityProblem {
	
	private HashMap<String, List<String>> GenerateMap(String filePath) throws FileNotFoundException, IOException
	{
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		       // sb.append(line);
		       // sb.append(System.lineSeparator());
		    	String[] parts = line.split(":");
		    	String person = parts[0];
		    	List<String> knowns = new ArrayList<String>();
		    	if(parts.length > 1)
		    	{
		    		parts = parts[1].split(",");
		    	
		    	//List<String> knowns = new ArrayList<String>();
		    		for(String x: parts)
		    		{
		    			knowns.add(x);
		    		}
		    		map.put(person, knowns);
		    	}
		    	else
		    		map.put(person, knowns);
		    	
		        line = br.readLine();
		    }
		    return map;
	}		
	}
	
	private String FindCelebrity(HashMap<String, List<String>> map)
	{
		Queue<String> q = new LinkedList<String>();
		for(String key : map.keySet())
		{
			q.add(key);
		}
		
		while(q.size() > 1)
		{
			String per1 = q.poll();
			String per2 = q.poll();
			
		    List<String> list1 = map.get(per1);
		    List<String> list2 = map.get(per2);
		 
		    if(!list1.contains(per2) && list2.contains(per1))
		    {
		    	q.add(per1);
		    }
		    else
			    if(list1.contains(per2) && !list2.contains(per1))
			    {
			    	q.add(per2);
			    }
		}
		
		if(q.isEmpty())
			return "No celebrity";
		else
		{
			String celeb = q.poll();
			for(String key : map.keySet())
			{
				if(key != celeb && !map.get(key).contains(celeb))
					return "No celebrity";
			}
			
			if(map.get(celeb).isEmpty())
				return celeb;
			else
				return "No celebrity";
		}
	}
	
	public static void main(String[] a) throws FileNotFoundException, IOException
	{
		TheCelebrityProblem solution = new TheCelebrityProblem();
		HashMap<String, List<String>> map = solution.GenerateMap("/Users/widea/Documents/eclipse/workspace/Amazon/TheCelebrityProblem/test.txt");   
		System.out.println("Guest list: " +map);
		System.out.println(solution.FindCelebrity(map));
	}
	
}
