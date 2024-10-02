https://leetcode.com/problems/minimum-falling-path-sum/description/

### Recursion 

```java
class Solution {

    int Rows;
    int Cols;

    public int minFallingPathSum(int[][] matrix) {

        Rows = matrix.length;
        Cols = matrix[0].length;

        int min = Integer.MAX_VALUE, tmp;

        for (int i = 0; i < Cols; i++) {
            tmp = calMinFallingPathSum(matrix, Rows - 1, i);

            min = min < tmp ? min : tmp;
        }

        return min;
    }

    private int calMinFallingPathSum(int[][] matrix, int row, int col) {

        if (col < 0 || col >= Cols) {
            // to avoid overflow
            // its given -100 <= matrix[i][j] <= 100
            return Integer.MAX_VALUE - 1000;
        }

        if (row == 0) {
            return matrix[row][col];
        }

        int down = matrix[row][col] + calMinFallingPathSum(matrix, row - 1, col);
        int leftDig = matrix[row][col] + calMinFallingPathSum(matrix, row - 1, col - 1);
        int rightDig = matrix[row][col] + calMinFallingPathSum(matrix, row - 1, col + 1);

        return Math.min(down, Math.min(leftDig, rightDig));
    }
}
```