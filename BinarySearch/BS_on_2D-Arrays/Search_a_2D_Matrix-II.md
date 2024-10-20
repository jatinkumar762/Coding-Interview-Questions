https://leetcode.com/problems/search-a-2d-matrix-ii/description/

### Optimized Approach - linear solution

* starting point can be  &rarr; (0, n-1) or (n-1, 0) 
* from these points two direction decide can be possible, one is strictly increasing or other is decreasing

--

* these can not be, starting point &rarr; (0, n-1) or (n-1, 0) 
* bcz we can not decide, in which direction we will proceed, because both are increasing

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0, j = cols - 1;

        while (i < rows && j >= 0) {

            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
```

**Time Complexity:** $O(rows + cols)$

### Binary Search

* for each row, we apply binary search

**Time Complexity:** $O(rows * logs(cols))$

