
### https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

**Approach-1**
* if traverse array from right side
    -  for each element we need to check max on its right side

**Approach-2**
* if traverse array from left side
    -  for each element we need to check min on its left side


```java
class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int max = 0, res = 0;

        // for each we find max value its right side
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            res = res > (max - prices[i]) ? res : (max - prices[i]);
        }
        return res;
    }
}
```

---

### https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

**Approach-1** &rarr; $0ms$

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

**Approach-2** &rarr; $1ms$

* the buying day will be the last continuous day that the price is smallest.
* Then, the selling day will be the last continuous day that the price is biggest.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0, min = 0, res = 0, i = 0;

        // for each we find max value its right side
        while (i < n-1) {
            min = prices[i];
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                min = prices[i+1];
                i++;
            }
            max = prices[i];
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                max = prices[i+1];
                i++;
            }

            res += max - min;
        }
        return res;
    }
}
```

---

### https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
