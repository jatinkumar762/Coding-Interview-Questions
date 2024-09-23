https://leetcode.com/problems/climbing-stairs/description/

Recursive Eq. ways(n) = ways(n-1) +  ways(n-2);

ways(1) = 1;

ways(2) = 2;

ways(3) = ways(2) + ways(1) = 3

ways(4) = ways(3) + ways(2) = 5


#### TopDown Approach - Memorization

```java
class Solution {

    int[] dp;

    public int countWays(int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = countWays(n - 1) + countWays(n - 2);

        return dp[n];
    }

    public int climbStairs(int n) {

        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return countWays(n);
    }
}
```

#### Bottom-up Approach - Table

```java
class Solution {

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
```