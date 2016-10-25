/*
Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1

Source: LeetCode
*/

public class MinReplacements {
    
    public int integerReplacement(int n) {
       if(n == 1)
       return 0;
       
        else if(n % 2 == 0)
            {
                
                return 1 + integerReplacement(n/2);
            }
            else
            {
                if(n == Integer.MAX_VALUE)
                    return integerReplacement(n - 1);
                return 1 + Math.min(integerReplacement(n - 1), integerReplacement(n+1));
            }
    }
}
