https://leetcode.com/problems/n-queens/description/


```java

class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> results = new ArrayList<>();

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(results, board, 0, n);

        return results;
    }

    private void backtrack(List<List<String>> results, char[][] board, int col, int n) {

        if (col == n) {
            // means we successfully placed all queens
            // store this chessboard positions in results
            results.add(constructSolution(board, n));
            return;
        }

        // for col, in rows find queen postions
        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(results, board, col + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private List<String> constructSolution(char[][] board, int n) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            solution.add(new String(board[i]));
        }
        return solution;
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {

        // check the row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
```

**Time Complexity:** $O(N!)$

* In the worst case, the algorithm explores all possible configurations for placing N queens.
* Each queen can be placed in any of the N rows, leading to N! configurations
* because after placing a queen in one row, it cannot be placed in the same column in subsequent rows.
* The isSafe method checks for conflicts, which helps prune the search space significantly. Despite this, in the worst case, the algorithm may still check a large number of placements.
* The worst-case time complexity is $O(N!)$