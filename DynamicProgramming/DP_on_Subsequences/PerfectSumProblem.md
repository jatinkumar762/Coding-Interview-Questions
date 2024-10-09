https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

### Recursive

```java
class Solution{
    
    int modulo = 1000000007;
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    return findPerfectSum(arr, n-1, sum);
	}
	
	private int findPerfectSum(int[] arr, int currIndex, int sum){
	    
	    if(currIndex < 0){
	        if(sum == 0){
	            return 1;
	        }
	        return 0;
	    }
	    
	    int not_take = findPerfectSum(arr, currIndex-1, sum);
	    
	    int take = 0;
	    if(arr[currIndex]<=sum){
	        take = findPerfectSum(arr, currIndex-1, sum-arr[currIndex]);
	    }
	    
	    return (not_take + take)%modulo;
	}
}
```

**Test Case:** arr = [0, 0, 5], target = 5, output = 4 &rarr; {0, 0, 5}, {0, 5}, {0, 5}, {5}

**Note:** if write below base case it will give wrong result

```
if(sum==0){
    return 1;
}

if(currIndex == 0){
    if(arr[currIndex] == sum){
        return 1;
    }
    return 0;
}
```

### Top-Down (Memorization)

```java
class Solution{
    
    int modulo = 1000000007;
    int[][] dp;
    
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    dp = new int[n][sum+1];
	    
	    for(int[] row : dp){
	        Arrays.fill(row, -1);
	    }
	    
	    findPerfectSum(arr, n-1, sum);
	    
	    return dp[n-1][sum];
	}
	
	private int findPerfectSum(int[] arr, int currIndex, int sum){
	    
	    if(currIndex < 0){
	        if(sum == 0){
	            return 1;
	        }
	        return 0;
	    }
	    
	    if(dp[currIndex][sum]!=-1){
	        return dp[currIndex][sum];
	    }
	    
	    int not_take = findPerfectSum(arr, currIndex-1, sum);
	    
	    int take = 0;
	    if(arr[currIndex]<=sum){
	        take = findPerfectSum(arr, currIndex-1, sum-arr[currIndex]);
	    }
	    
	    return dp[currIndex][sum] = (not_take + take)%modulo;
	}
}
```