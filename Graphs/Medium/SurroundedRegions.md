https://leetcode.com/problems/surrounded-regions/description/

```java
class Solution {
    boolean[][] visited;
    int Rows, Cols;

    public void solve(char[][] board) {

        Rows = board.length;
        Cols = board[0].length;

        visited = new boolean[Rows][Cols];

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if ((i == 0 || i == Rows - 1 || j == 0 || j == Cols - 1) && board[i][j] == 'O'
                        && visited[i][j] == false) {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {

        visited[r][c] = true;
        board[r][c] = 'T';

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= 0 && newR < Rows && newC >= 0 && newC < Cols && !visited[newR][newC]
                    && board[newR][newC] == 'O') {
                dfs(newR, newC, board);
            }
        }

    }
}
```