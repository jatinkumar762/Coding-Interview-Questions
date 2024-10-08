https://leetcode.com/problems/unique-paths-ii/description/

**Test Cases:**

1. [[1,0]] &rarr; 0

2. [[0,0],[0,1]] &rarr; 0


### Recursive

```java
class Solution {

    int Rows, Cols;

    public int countUniquePath(int[][] obstacleGrid, int r, int c) {

        if (r == Rows - 1 && c == Cols - 1 && obstacleGrid[r][c] == 0) {
            return 1;
        } else if (r == Rows || c == Cols || obstacleGrid[r][c] == 1) { // outside grid
            return 0;
        } 

        int rightPath = countUniquePath(obstacleGrid, r, c + 1);

        int downPath = countUniquePath(obstacleGrid, r + 1, c);

        return rightPath + downPath;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Rows = obstacleGrid.length;
        Cols = obstacleGrid[0].length;

        return countUniquePath(obstacleGrid, 0, 0);
    }
}
```

### Top-Down

```java
class Solution {
    int[][] dp;

    public int countUniquePath(int[][] obstacleGrid, int r, int c) {

        if (r == 0 && c == 0 && obstacleGrid[r][c] == 0) {
            return 1;
        } else if (r == -1 || c == -1 || obstacleGrid[r][c] == 1) { // outside grid
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int leftPath = countUniquePath(obstacleGrid, r, c - 1);

        int downPath = countUniquePath(obstacleGrid, r - 1, c);

        return dp[r][c] = leftPath + downPath;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dp[m - 1][n - 1] = countUniquePath(obstacleGrid, m - 1, n - 1);
    }
}
```

### Bottom-Up

```java
class Solution {
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {

                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }

                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }

                    //[[1,0]] - test case
                    // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; 

                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
```

**Space Optimization**

```java
class Solution {
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prev = new int[n];
        int[] tmp;

        for (int i = 0; i < m; i++) {

            tmp = new int[n];

            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    tmp[j] = 0;
                } else if (i == 0 && j == 0) {
                    tmp[j] = 1;
                } else {

                    if (i > 0) {
                        tmp[j] += prev[j];
                    }

                    if (j > 0) {
                        tmp[j] += tmp[j - 1];
                    }
                }
            }

            prev = tmp;
        }

        return prev[n - 1];
    }
}
```