/*
Question: Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
          For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 
Source : Leet code, Solution by : prateek470           
*/

class PerfectSquares{
public int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=Math.sqrt(i);j++){
                min = Math.min(min,dp[i-(j*j)]+1);
            }
            dp[i]=min;
        }
        return dp[n];
    }
    }
