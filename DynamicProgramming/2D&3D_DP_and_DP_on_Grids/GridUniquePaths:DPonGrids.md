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
