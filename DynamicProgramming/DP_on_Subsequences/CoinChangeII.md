https://leetcode.com/problems/coin-change-ii/description/

### Recursion 

```java
class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;

        return calCombinations(coins, n - 1, amount);
    }

    private int calCombinations(int[] coins, int index, int amount) {

        // Input: amount = 5, coins = [1,2,5]
        // Output: 4
        
        if (amount == 0) {
            // no coins required - 1 way - empty subset
            return 1;
        }

        if (index == 0) {
            if (amount % coins[index] == 0) {
                return 1; // 1 way
            }
            return 0;
        }

        int notTake = calCombinations(coins, index - 1, amount);

        int take = 0;
        if (coins[index] <= amount) {
            take = calCombinations(coins, index, amount - coins[index]);
        }

        return take + notTake;
    }
}
```

### Top-Down (Memorization)

```java
class Solution {

    int[][] dp;

    public int change(int amount, int[] coins) {

        int n = coins.length;

        dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        calCombinations(coins, n - 1, amount);

        return dp[n - 1][amount];
    }

    private int calCombinations(int[] coins, int index, int amount) {

        // Input: amount = 5, coins = [1,2,5]
        // Output: 4

        if (amount == 0) {
            // no coins required - 1 way - empty subset
            return dp[index][amount] = 1;
        }

        if (index == 0) {
            if (amount % coins[index] == 0) {
                return dp[index][amount] = 1; // 1 way
            }
            return dp[index][amount] = 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notTake = calCombinations(coins, index - 1, amount);

        int take = 0;
        if (coins[index] <= amount) {
            take = calCombinations(coins, index, amount - coins[index]);
        }

        return dp[index][amount] = take + notTake;
    }
}
```