https://leetcode.com/problems/coin-change/description/

### Recursion

```java
class Solution {
    public int coinChange(int[] coins, int amount) {

        // min no of coins
        if (amount == 0) {
            return 0;
        }

        int n = coins.length;

        int res = calMinCoins(coins, n - 1, amount);

        return res != Integer.MAX_VALUE ? res : -1;
    }

    private int calMinCoins(int[] coins, int index, int amount) {

        if (amount == 0) {
            // no coins required
            return 0;
        }

        if (index == 0) {
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            }
            return Integer.MAX_VALUE; // no overflow so -100
        }

        int notTake = calMinCoins(coins, index - 1, amount);

        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            take = calMinCoins(coins, index, amount - coins[index]);
            if (take != Integer.MAX_VALUE) {
                take += 1;
            }
        }

        return take < notTake ? take : notTake;
    }
}
```

**Time Complexity:** >> O(2^n) &rarr; exponential

**Space Complexity:** >> O(n) &rarr; if coin = 1 then max O(target) - max recursion tree 