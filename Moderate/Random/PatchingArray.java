/*
Question: Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Source: LeetCode.
*/

public class PatchingArray
{
public int minPatches(int[] nums, int n) {
	
	int sum = 1;
	int i = 0;
	int count = 0;
	
	while(sum <= n){
		if(i < nums.length && nums[i] <= sum)
		{
			sum+=nums[i];
      			i++;
		}
		else
		{
			sum += sum;
			count++;
		}
	}
	
	return count;
}
}
