https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

### Recursive

```java
class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        return calMaxProfit(wt, val, N-1, W);
    }
    
    static int calMaxProfit(int[] wt, int[] val, int index, int W){
        
        
        if(W == 0){
            return 0;
        }
        
        if(index < 0 || W < 0){
            return 0;
        }
        
        int notTake = calMaxProfit(wt, val, index-1, W);
        
        int take = 0;
        
        if(wt[index]<=W){
            take = val[index] + calMaxProfit(wt, val, index, W-wt[index]);
        }
        
        
        return take > notTake ? take : notTake;
    }
}
```

### Top-Down Approach (Memorization)

```java
class Solution{
    
    static int[][] dp;
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        dp = new int[N][W+1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        calMaxProfit(wt, val, N-1, W);
        
        return dp[N-1][W];
    }
    
    static int calMaxProfit(int[] wt, int[] val, int index, int W){
        
        
        if(index < 0 || W < 0){
            return 0;
        }
        
        if(W == 0){
            return dp[index][W] = 0;
        }
        
        if(dp[index][W]!=-1){
            return dp[index][W];
        }
        
        int notTake = calMaxProfit(wt, val, index-1, W);
        
        int take = 0;
        
        if(wt[index]<=W){
            take = val[index] + calMaxProfit(wt, val, index, W-wt[index]);
        }
        
        
        return dp[index][W] = (take > notTake ? take : notTake);
    }
}
```