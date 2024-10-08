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

**Space Complexity:** $O(n)

