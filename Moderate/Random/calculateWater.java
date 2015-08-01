// Calculate how much water contained by j-th glasses -- Amazon
// Reference: https://sites.google.com/site/spaceofjameschen/home/array/calculate-how-many-water-contained-by-jth-glasses----amazon

/*
Problem
There are some glasses with equal volume 1 liter. The glasses kept as follows:

            1
          2   3
       4    5    6
     7    8    9   10
You can put water to only top glass. If you put more than 1 liter water to 1st glass, water overflow and fill equally both 2nd and 3rd glass. Glass 5 will get water from both 2nd glass and 3rd glass and so on.. 
If you have X liter of water and you put that water in top glass, so tell me how much water contained by j-th glass in i-th row. 
Example. If you will put 2 liter on top. 
1st – 1 liter 
2nd – 1/2 liter 
3rd - 1/2 liter

level 0: 1
level 1: 1/2  1/2
level 2: 1/4  2/4  1/4
level 3: 1/8  3/8  3/8  1/8
level 4: 1/16  4/16  6/16  4/16  1/16
*/

public class calculateWater
{
	static void calculate(int jth, int ith, double water)
	{
		if(ith < 0 || jth < 0 || jth > ith )
			{
				System.out.println("Incorrect input");
				return;
			}
		
		float[] prevLevel = new float[ith + 1];
	    float[] currLevel = new float[ith + 1];

	    for(int i = 0; i < ith + 1; ++i){
	        prevLevel[i] = currLevel[i] = 0.0f;
	    }
		
	    prevLevel[0] = (float)water;
		
		for(int level = 0; level < ith ; level++ )
		{
			for(int j = 0 ; j <= level ; j++)
			{
				if(prevLevel[j] > 1)
				{
	                currLevel[j] += (prevLevel[j] - 1) / 2;
	                currLevel[j + 1] += (prevLevel[j] - 1) / 2;
	            }
			}
			
			for(int i = 0; i <= level + 1; ++i)
			{
	            prevLevel[i] = currLevel[i];
	            currLevel[i] = 0;
	        }			
		}
		
		System.out.println(prevLevel[jth] > 1 ? 1 : prevLevel[jth]);
				
	}
	
	public static void main(String[] args)
	{
		calculate(0, 0, 0);
	    calculate(0, 0, 0.5);
	    calculate(0, 0, 1.0);
	    calculate(0, 0, 1.5);
	    calculate(0, 1, 0.5);
	    calculate(0, 1, 1);
	    calculate(0, 1, 1.5);
	    calculate(0, 1, 3);
	    calculate(0, 1, 3.5);
	    calculate(1, 1, 0.5);
	    calculate(1, 1, 1);
	    calculate(1, 1, 1.5);
	    calculate(1, 1, 3);
	    calculate(1, 1, 3.5);
	    calculate(0, 2, 0.5);
	    calculate(0, 2, 3.0);
	    calculate(0, 2, 4.5);
	    calculate(0, 2, 6);
	    calculate(1, 2, 1.5);
	    calculate(1, 2, 3);
	    calculate(1, 2, 5);
	    calculate(1, 2, 6);
	    calculate(2, 2, 1.5);
	    calculate(2, 2, 3);
	    calculate(2, 2, 5);
	    calculate(2, 2, 6);
	    calculate(0, 3, 8);
	    calculate(1, 3, 8);
	    calculate(2, 3, 8);
	    calculate(3, 3, 8);	}
}
 