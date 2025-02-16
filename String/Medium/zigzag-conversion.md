https://leetcode.com/problems/zigzag-conversion/description/

### Approach-1 Basic

* Simulate Zig-Zag Movement

```java
class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        int len = s.length();

        StringBuilder res = new StringBuilder("");

        //max col possible can be string length
        //row=1
        
        char[][] matrix = new char[numRows][len];

        for (char[] mat : matrix) {
            Arrays.fill(mat, '$');
        }

        int r = 0, c = 0;
        int i = 0;

        while (i < len) {
            while (r < numRows && i < len) {
                matrix[r][c] = s.charAt(i);
                r++;
                i++;
            }

            r -= 2;
            c++;
            while (r > 0 && i < len) {

                matrix[r][c] = s.charAt(i);
                i++;
                r--;
                c++;
            }
        }

        for (int r_i = 0; r_i < numRows; r_i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[r_i][j] != '$') {
                    res.append(matrix[r_i][j]);
                }
            }
        }

        return res.toString();
    }
}
```

**LeetCode Solution**

![Zig-Zag Movement](./Zig-Zag%20Movement.png)

- Each section will have at most  numRows - 1  columns in it (the last section might have fewer columns), as can be seen in the above example.
- In each section, we will have $2 * numRow - 2 characters$, (numRow characters in one column and numRow - 2 in the diagonal).
- Thus, for a string of n characters, we will require at most $ceil(n / (2 * numRows - 2))$ sections, and as each section will have numRows - 1 columns. We can say we need $ceil(n / (2 * numRows - 2)) * (numRows - 1)$ columns.
- So, our matrix will be of dimension, $numRows×numCols$, where numCols = $ceil(n / (2 * numRows - 2)) * (numRows - 1)$.

</br>

```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
        int numCols = sections * (numRows - 1);

        char[][] matrix = new char[numRows][numCols];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }

        int currRow = 0, currCol = 0;
        int currStringIndex = 0;

        // Iterate in zig-zag pattern on matrix and fill it with string characters.
        while (currStringIndex < n) {
            // Move down.
            while (currRow < numRows && currStringIndex < n) {
                matrix[currRow][currCol] = s.charAt(currStringIndex);
                currRow++;
                currStringIndex++;
            }

            currRow -= 2;
            currCol++;

            // Move up (with moving right also).
            while (currRow > 0 && currCol < numCols && currStringIndex < n) {
                matrix[currRow][currCol] = s.charAt(currStringIndex);
                currRow--;
                currCol++;
                currStringIndex++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char[] row : matrix) {
            for (char character : row) {
                if (character != ' ') {
                    answer.append(character);
                }
            }
        }

        return answer.toString();
    }
}
```