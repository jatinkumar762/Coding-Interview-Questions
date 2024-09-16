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

#### Approach-2 rotate the image in-place $O(1)$

```java
/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
void rotate(vector<vector<int> > &matrix) {
    reverse(matrix.begin(), matrix.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}
```

**Note:** anticlockwise rotate

```java
/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
void anti_rotate(vector<vector<int> > &matrix) {
    for (auto vi : matrix) reverse(vi.begin(), vi.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}
```