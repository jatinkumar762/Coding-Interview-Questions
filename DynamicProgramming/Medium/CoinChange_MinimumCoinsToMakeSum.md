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

**GFG Solution-Recursive**

```java
// A Naive recursive Java program to find minimum of coins
// to make a given change sum
import java.io.*;
public class coin
{
    // m is size of coins array (number of different coins)
    static int minCoins(int coins[], int m, int sum)
    {
       // base case
       if (sum == 0) return 0;
     
       // Initialize result
       int res = Integer.MAX_VALUE;
     
       // Try every coin that has smaller value than sum
       for (int i=0; i<m; i++)
       {
         if (coins[i] <= sum)
         {
             int sub_res = minCoins(coins, m, sum-coins[i]);
     
             // Check for INT_MAX to avoid overflow and see if
             // result can minimized
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                res = sub_res + 1;
         }
       }
       return res;
    }
    public static void main(String args[])
    {
       int coins[] =  {9, 6, 5, 1};
       int m = coins.length;
       int sum = 11;
       System.out.println("Minimum coins required is "+ minCoins(coins, m, sum) );
    }
}
```

