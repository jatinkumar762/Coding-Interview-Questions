https://leetcode.com/problems/word-search/description/


### Approach-1 Recursion

```java
class Solution {

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int m, n, len;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        len = word.length();

        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];

        if (m * n < len) {
            return false;
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0) && checkWord(r, c, board, word, 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkWord(int row, int col, char[][] board, String word, int index) {

        if (len == index) {
            return true;
        }

        visited[row][col] = true;

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                if (board[newRow][newCol] == word.charAt(index) && !visited[newRow][newCol]) {

                    //visited[newRow][newCol] = true;

                    if (checkWord(newRow, newCol, board, word, index + 1)) {
                        return true;
                    }

                    visited[newRow][newCol] = false;
                }

            }
        }

        return visited[row][col] = false;
    }
}
```