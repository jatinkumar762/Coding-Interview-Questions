https://www.geeksforgeeks.org/problems/rod-cutting0840/1

* rod cutting problem is similar to DP - knapsack-with-duplicate-items
* given rod is of length N, and each rod size has price/profit associated with it
* rod can be of size &rarr; 1, 2, 3.......N
* now we need to pick from different rod size


n = 8, price[] = {1, 5, 8, 9, 10, 17, 17, 20}
    index &rarr;  0  1  2  3   4   5   6   7
    len   &rarr;  1  2  3  4   5   6   7   8


so here we need to chose among 1 to 8 length pieces, and max sum of selected rod size is 8
            

### Top-Down (Memorization)

```java
class Solution{
    
    int[][] dp;
    
    public int cutRod(int price[], int n) {
        //code here
        
        dp = new int[n][n+1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        calMaxProfit(price, n-1, n);
        
        return dp[n-1][n]; //max profit n piece of length
    }
    
    private int calMaxProfit(int[] val, int index, int N){
        
        
        if(index < 0 || N < 0){
            return Integer.MIN_VALUE;
        }
        
        if(N == 0){
            return dp[index][N] = 0;
        }
        
        if(dp[index][N]!=-1){
            return dp[index][N];
        }
        
        int notTake = calMaxProfit(val, index-1, N);
        
        int take = Integer.MIN_VALUE;
        
        int rodLength = index+1;
        
        if(rodLength<=N){
            take = val[index] + calMaxProfit(val, index, N-rodLength);
        }
        
        
        return dp[index][N] = (take > notTake ? take : notTake);
    }
}
```
