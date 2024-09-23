https://www.geeksforgeeks.org/problems/geek-jump/1

#### Recursive Solution - TLE

```java
class Solution{
    
    public int calculateEnergy(int[] arr, int currIndex, int N){
        
        if(currIndex>=N-1){
            return 0;
        }
        
        int res1 = Integer.MAX_VALUE, res2 = Integer.MAX_VALUE;
        
        if(currIndex+1<=N-1){
            res1 = Math.abs(arr[currIndex] - arr[currIndex+1]) + calculateEnergy(arr, currIndex + 1, N);
        }
        
        if(currIndex+2<=N-1){
            res2 =  Math.abs(arr[currIndex] - arr[currIndex+2]) + calculateEnergy(arr, currIndex + 2, N);
        }
        
        return Math.min(res1, res2);
    }
    
    public int minimumEnergy(int arr[],int N){
        
        //code here
        
        return calculateEnergy(arr, 0, N);
    }
}
```

#### Top-Down Approach - StackOverflow error 

* left skewed tree - one jump

```java
class Solution{
    
    int[] dp;
    
    public int calculateMinEnergy(int[] arr, int index, int N)
    {
        if(index==0){
            dp[index] = 0;
            return dp[index];
        }
        
        if(dp[index]!=-1){
            return dp[index];
        }
        
        int e1 = Integer.MAX_VALUE, e2 = Integer.MAX_VALUE;
        
        e1 = Math.abs(arr[index] - arr[index-1]) + calculateMinEnergy(arr, index-1, N);
        
        if(index-2>=0){
            e2 = Math.abs(arr[index] - arr[index-2]) + calculateMinEnergy(arr, index-2, N);
        }
        
        dp[index] = e1 < e2 ? e1 : e2;
        
        return dp[index];
    }
    
    public int minimumEnergy(int arr[],int N){
        //code here
        dp = new int[N];
        
        Arrays.fill(dp, -1);
        
        return calculateMinEnergy(arr, N-1, N);
    }
}
```