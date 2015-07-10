import java.util.Scanner;

// Select movie -- Google
// Reference: https://sites.google.com/site/spaceofjameschen/home/string/select-movie----google
/*
 I need a function that takes the name of the movie to look up and 
the width of the letter grid, and computes the key presses that 
will enter that string on the DVR grid. The output should be a 
string, with "u", "d", "l", "r", and "!" corresponding to up, 
down, left, right, and select. 

For example, with a grid of width 5, 
a b c d e 
f g h i j 
k l m n o 
p q r s t 
u v w x y 
z 
the movie "up" would be "dddd!u!". 
*/

public class selectMovie
{
	static int a = 0;
	static int b = 0;
	
	static void getName(int w, String name)
	{
		//StringBuffer out = new StringBuffer("");
		//char[][]
		for(int i = 0; i < name.length() ; i++)
		{
			char target = Character.toLowerCase(name.charAt(i));			
			int target_i = target - 97 / w;
			int target_j = target - 97 % w;
			
			System.out.println(getPath(target_i,target_j));
		}
		
		
	}
	
	
	static String getPath(int ith, int jth)
	{
		StringBuffer out = new StringBuffer("");
		
		 while(a != ith){
			
			if(a > ith)
				{out.append("u");
				a--;
				}
			
			if(a < ith)
			{
				out.append("d");
				a++;
			}
				
		}
		 
		 while(b != jth){
				
				if(b > jth)
					{out.append("l");
					a--;
					}
				
				if(a < ith)
				{
					out.append("r");
					a++;
				}
					
			}
		 
		 out.append("!");
			
		
		return out.toString();
	}

	
	
	
	public static void main(String[] args)
	{
		System.out.println("Enter the width length: ");
		Scanner in = new Scanner(System.in);
		int width = in.nextInt();
		System.out.println("Enter the movie name: ");
		in.nextLine();
		String name = in.nextLine();
		getName(width,name);
	}
}
