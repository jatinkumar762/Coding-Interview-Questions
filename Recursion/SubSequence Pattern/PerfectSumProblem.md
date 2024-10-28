https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

### Recursion

```java
class Solution{
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    return countPerfectSum(arr, 0, n, 0, sum);
	}
	
	private int countPerfectSum(int[] arr, int index, int len, int currentSum, int targetSum) {
	    
	    if(currentSum > targetSum){
	        return 0;
	    }
	    
	    //targetSum = 3
	    //[1, 2, 0, 0, 0]
	    if(index == len && currentSum == targetSum){
	        return 1;
	    }
	    
	    if(index >= len ){
	        return 0;
	    }
	    
	    
	    //take
	    int takeSum = countPerfectSum(arr, index + 1, len, currentSum+arr[index], targetSum);
	    
	    //not-take
	    int notTakeSum = countPerfectSum(arr, index + 1, len, currentSum, targetSum);
	    
	    
	    return takeSum + notTakeSum;
	}
}
```

### Memorization - Top-Down Approach

```java
class Solution{
    
    int[][] dp;
    int mod = 1000000007;
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp = new int[n][sum+1];
	    
	    for(int[] row : dp){
	        Arrays.fill(row, -1);
	    }
	    
	    countPerfectSum(arr, n-1, sum);
	    
	    return dp[n-1][sum];
	}
	
	private int countPerfectSum(int[] arr, int index, int targetSum) {
	    
	    //targetSum = 3
	    //[1, 2, 0, 0, 0]
	    if(index < 0 && targetSum == 0){
	        return 1;
	    }
	    
	    if(index < 0 || targetSum < 0){
	        return 0;
	    }
	   
	    
	    if(dp[index][targetSum]!=-1){
	        return dp[index][targetSum];
	    }
	    
	    
	    //take
	    int takeSum = countPerfectSum(arr, index - 1, targetSum-arr[index]);
	    
	    //not-take
	    int notTakeSum = countPerfectSum(arr, index - 1, targetSum);
	    
	    
	    return dp[index][targetSum] = (takeSum + notTakeSum) % mod;
	}
}
```

### Tabulation - Bottom-Up Approach

```java
class Solution{
    
    int[][] dp;
    int mod = 1000000007;
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp = new int[n+1][sum+1];
	    
	    for(int j = 1; j <= sum; j++){
	        dp[0][j] = 0;
	    }
	    
	    for(int i = 0; i <= n; i++){
	        dp[i][0] = 1;
	    }
	    
	    for(int i = 1; i<=n; i++){
	        for(int j = 1; j <= sum; j++){
	            
	            int notTake = dp[i-1][j];
	            
	            int take = 0;
	            if(j>=arr[i-1]){
	                take = dp[i-1][j-arr[i-1]];
	            }
	            
	            dp[i][j] = (take + notTake) % mod;
	        }
	    }
	    
	    /*
	    for(int[] row : dp){
	        System.out.println(Arrays.toString(row));
	    }
	    */
	   
	    return dp[n][sum];
	}
	
}
```