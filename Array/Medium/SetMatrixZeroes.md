https://leetcode.com/problems/set-matrix-zeroes/description/

**Note:**
* in question, they asked &rarr; Could you devise a constant space solution?

#### Approach-1 Marking future 0 index with some value

1. -2^31 <= matrix[i][j] <= 2^31 - 1 (full int number range)
2. so below solution will not work

```java
class Solution {

    int ROWS;
    int COLS;

    public void setZeroes(int[][] matrix) {

        ROWS = matrix.length;
        COLS = matrix[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println(i + " " + j);
                    makeZeros(matrix, i, j);
                }
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void makeZeros(int[][] matrix, int r, int c) {

        for (int i = 0; i < ROWS; i++) {
            if (matrix[i][c] != 0) {
                // bcz otherwise will override original matrix 0
                // we will not able to make correctly other zeros
                matrix[i][c] = -1;
            }
        }

        for (int j = 0; j < COLS; j++) {
            if (matrix[r][j] != 0) {
                matrix[r][j] = -1;
            }
        }
    }
}
```

**Hints:**

1. If any cell of the matrix has a zero we can record its row and column number using additional memory. But if you don't want to use extra memory then you can manipulate the array instead. i.e. simulating exactly what the question says.
2. Setting cell values to zero on the fly while iterating might lead to discrepancies. What if you use some other integer value as your marker? There is still a better approach for this problem with 0(1) space.
3. We could have used 2 sets to keep a record of rows/columns which need to be set to zero. But for an O(1) space solution, you can use one of the rows and and one of the columns to keep track of this information.
4. We can use the first cell of every row and column as a flag. This flag would determine whether a row or column has been set to zero.


#### Approach-2

```java
class Solution {

    public void setZeroes(int[][] matrix) {

        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        boolean firstRowHasZero = false, firstColHasZero = false;
        for (int i = 0; i < ROWS; i++) {
            if (matrix[i][0] == 0) {
                firstRowHasZero = true;
            }
        }
        for (int j = 0; j < COLS; j++) {
            if (matrix[0][j] == 0) {
                firstColHasZero = true;
            }
        }

        // going to use first row and first col as flag
        for (int i = 1; i < ROWS; i++) {
            for (int j = 1; j < COLS; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < ROWS; i++) {
            for (int j = 1; j < COLS; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < ROWS; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstColHasZero) {
            for (int j = 0; j < COLS; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
```