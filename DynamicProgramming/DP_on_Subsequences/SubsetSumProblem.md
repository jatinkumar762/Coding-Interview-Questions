https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

### Recursive

```java
class Solution{
    
    static boolean checkSubsetSum(int arr[], int sum, int currIndex){
        
        if(currIndex<0){
            return false;
        }
        
        if(arr[currIndex]==sum || sum==0){
            return true;
        }
        
        boolean notTake = checkSubsetSum(arr, sum, currIndex-1);
        
        boolean take = false;
        
        if(arr[currIndex]<=sum){
            take = checkSubsetSum(arr, sum-arr[currIndex], currIndex-1);
        }
        
        return (notTake || take);
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        return checkSubsetSum(arr, sum, N-1);
    }
}
```

**Time Complexity:** $O(2^n)$

**Space Complexity:** $O(n)$

### Memorization

```java
class Solution{
    
    //why not boolean, to check unvisited location
    //in boolean only true/false possible
    static int[][] dp;
    
    static int checkSubsetSum(int arr[], int sum, int currIndex){
        
        if(currIndex<0){
            return 0;
        }
        
        if(arr[currIndex]==sum || sum==0){
            return dp[currIndex][sum]=1;
        }
        
        if(dp[currIndex][sum]!=-1){
            return dp[currIndex][sum];
        }
        
        int notTake = checkSubsetSum(arr, sum, currIndex-1);
        
        int take = 0;
    
        if(arr[currIndex]<=sum){
            take = checkSubsetSum(arr, sum-arr[currIndex], currIndex-1);
        }
        
        return dp[currIndex][sum] = notTake | take;
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        dp = new int[N][sum+1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return checkSubsetSum(arr, sum, N-1) == 1 ? true : false;
    }
}
```

**Time Complexity:** $O(n*sum)$

**Space Complexity:** $O(n*sum) + O(n)$

