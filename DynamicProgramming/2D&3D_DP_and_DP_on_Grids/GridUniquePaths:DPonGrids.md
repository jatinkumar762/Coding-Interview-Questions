https://leetcode.com/problems/unique-paths/description/

### Recursive Solution - TLE

```java
class Solution {

    int Rows, Cols;

    public int countUniquePath(int r, int c) {

        if (r == Rows - 1 && c == Cols - 1) {
            return 1;
        } else if (r == Rows || c == Cols) { // outside grid
            return 0;
        }

        int rightPath = countUniquePath(r, c + 1);

        int downPath = countUniquePath(r + 1, c);

        return rightPath + downPath;
    }

    public int uniquePaths(int m, int n) {

        Rows = m;
        Cols = n;

        return countUniquePath(0, 0);
    }
}
```

**Time-Complexity**

* at each step in grid, we are doing 2 choice &rarr; 2^(m*n)

**Space-Complexity**

* max path length - recursive stack length

(3, 3) &rarr; (2, 3) &rarr; (1, 3) &rarr; (0, 3) &rarr; (0, 2) &rarr; (0, 1) &rarr; (0, 0)

* O(m-1) + O(n-1)


### Top-Down Approach

```java
class Solution {

    int[][] dp;

    public int countUniquePath(int r, int c) {

        if (r == 0 && c == 0) {
            return 1;
        } else if (r == -1 || c == -1) { // outside grid
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int leftPath = countUniquePath(r, c - 1);

        int downPath = countUniquePath(r - 1, c);

        return dp[r][c] = leftPath + downPath;
    }

    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dp[m - 1][n - 1] = countUniquePath(m-1, n-1);
    }
}
```

**Time-Complexity**

* $O(m*n)$ - each grid element visit once

**Space-Complexity**

* $O(m-1)$ + $O(n-1)$ + $O(m*n)

### Bottom-Up Approach - Tabulation

```java
class Solution {

    int[][] dp;
    
    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        // base case initialization
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; //left + down
            }
        }

        return dp[m - 1][n - 1];
    }
}
```

**another way to write above code**

```java
class Solution {

    int[][] dp;

    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // left + down
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
```

**Note: Space Optimization**

* we can see current result, depends on prev row and prev col &rarr; so we can do space optimization




