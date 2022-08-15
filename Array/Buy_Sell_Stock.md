
[Problem-1](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

```java
class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length<=1)
            return 0;
        
        int len = prices.length;
        int maxPrice = prices[len-1];
        int profit = 0;
        
        for(int j=len-2;j>=0;j--){
            if(prices[j]<maxPrice){
                if((maxPrice - prices[j])>profit)
                    profit = maxPrice - prices[j];
            } 
            else{
                maxPrice = prices[j];
            }
        }
        return profit;
    }
}
```

[Problem-2](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

```java
class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length<=1)
            return 0;
        
        int len = prices.length;
        int maxPrice = prices[len-1];
        int profit = 0;
        
        for(int j=len-2;j>=0;j--){
            if(prices[j]<maxPrice){
                    profit += maxPrice - prices[j];
                    maxPrice = prices[j];
            } 
            else{
                maxPrice = prices[j];
            }
        }
        return profit;
        
    }
}
```

[Problem-3](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
