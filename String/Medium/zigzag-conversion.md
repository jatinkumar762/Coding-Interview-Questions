https://leetcode.com/problems/zigzag-conversion/description/

### Approach-1 Basic

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