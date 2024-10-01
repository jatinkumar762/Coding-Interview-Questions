https://leetcode.com/problems/minimum-path-sum/description/

### Top-Down Approach

```java
class Solution {

    int[][] dp;

    public int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        dp = new int[r][c];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findMinPathSum(grid, r - 1, c - 1);
    }

    private int findMinPathSum(int[][] grid, int r, int c) {

        // base cases
        if (r == 0 && c == 0) {
            return dp[r][c] = grid[r][c];
        }

        if (r < 0 || c < 0) {
            // wont be part of path
            return Integer.MAX_VALUE;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        // if i add here grid[r][c] overflow will occur
        int up = findMinPathSum(grid, r - 1, c);

        int left = findMinPathSum(grid, r, c - 1);

        dp[r][c] = (up < left ? up : left) + grid[r][c];

        return dp[r][c];
    }
}
```

### Bottom-Up Approach 

```java
class Solution {

    public int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {

                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }

                    if (j > 0) {
                        left = dp[i][j - 1];
                    }

                    dp[i][j] = (up < left ? up : left) + grid[i][j];
                }
            }
        }

        return dp[r - 1][c - 1];
    }
}
```

**Note: other way to write above code**

```java
class Solution {

    public int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];

        int up, left;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {

                    up = dp[i - 1][j];

                    left = dp[i][j - 1];

                    dp[i][j] = (up < left ? up : left) + grid[i][j];
                }
            }
        }

        return dp[r - 1][c - 1];
    }
}
```

### SPace-Optimization

**java
class Solution {

    int[][] dp;

    public int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[] prev = new int[c];
        int[] curr = new int[c];

        int up, left;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else if (i == 0) {
                    curr[j] = grid[i][j] + curr[j - 1];
                } else if (j == 0) {
                    curr[j] = grid[i][j] + prev[j];
                } else {
                    curr[j] = (prev[j] < curr[j - 1] ? prev[j] : curr[j - 1]) + grid[i][j];
                }
            }
            prev = curr;
        }

        return prev[c - 1];
    }
}
```