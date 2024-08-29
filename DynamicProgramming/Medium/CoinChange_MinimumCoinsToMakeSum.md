https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/


#### Approach-1 Recursion

```java
class Solution {

    private int countCoins(int[] coins, int M, int sum, int count){
        
        if(sum==0){
            return count;
        }
        
        if(sum<0){
            return Integer.MAX_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<M;i++){
            if(coins[i]<=sum){
                min = Math.min(countCoins(coins, M, sum-coins[i], count+1), min);   
            }
        }
        return min;
    }
    
    public int minCoins(int coins[], int M, int sum) {
      
        // Your code goes here
        //Arrays.sort(coins);     
        int res = countCoins(coins, M, sum, 0);
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
}
```