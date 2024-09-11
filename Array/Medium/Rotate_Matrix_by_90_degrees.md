https://leetcode.com/problems/rotate-image/

#### Approach-1 By taking extra space

if we do observation, we find 

1. old_col_index = new_r_index
2. old_row_index = Rows-1- (new_c_index) //Rows=3 means (0..2)

**Example:**

- new index [0,0] = [2, 0] old index
- new index [0,1] = [1, 0]
- new index [0,2] = [0, 0]

```java
class Solution {
    public void rotate(int[][] matrix) {

        int Rows = matrix.length;
        int Cols = matrix[0].length;

        int newRows = Cols;
        int newCols = Rows;

        int[][] res = new int[newRows][newCols];

        
        for (int r = 0; r < newRows; r++) {
            for (int c = 0; c < newCols; c++) {
                res[r][c] = matrix[Rows - 1 - c][r];
            }
        }

        /*
         * for (int[] r : res) {
         * System.out.println(Arrays.toString(r));
         * }
         */

        // question given matrix is square matrix

        for (int r = 0; r < newRows; r++) {
            for (int c = 0; c < newCols; c++) {
                matrix[r][c] = res[r][c];
            }
        }
    }
}
```

#### Approach-2 rotate the image in-place

```java

```