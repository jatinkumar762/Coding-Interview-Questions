https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1

### Approach-1 Top-Down (Memorization)




### Approach-2 Bottom-Up (Tabulation)

```java
class Solution {
  public static boolean checkSubsequenceSum(int n, int[] arr, int sum) {
    // code here
    
        boolean[][] dp = new boolean[n+1][sum+1];
	    
	    for(int j = 1; j <= sum; j++){
	        dp[0][j] = false;
	    }
	    
	    for(int i = 0; i <= n; i++){
	        dp[i][0] = true;
	    }
	    
	    for(int i = 1; i<=n; i++){
	        for(int j = 1; j <= sum; j++){
	            
	            boolean notTake = dp[i-1][j];
	            
	            boolean take = false;
	            if(j>=arr[i-1]){
	                take = dp[i-1][j-arr[i-1]];
	            }
	            
	            dp[i][j] = notTake || take;
	        }
	    }
	   
	    return dp[n][sum];
  }
}
```