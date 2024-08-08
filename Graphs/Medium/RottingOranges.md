https://leetcode.com/problems/rotting-oranges/description/

```java
class Solution {
    int R;
    int C;
    int count;
    Queue<int[]> queue = new LinkedList<>();

    public int orangesRotting(int[][] grid) {

        R = grid.length;
        C = grid[0].length;
        count = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        //multi source bfs
        bfs(grid);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    void bfs(int[][] grid) {

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] index = queue.poll();
                if (isFresh(grid, index[0] - 1, index[1])) {
                    queue.add(new int[] { index[0] - 1, index[1] });
                    grid[index[0] - 1][index[1]] = 2;
                }

                if (isFresh(grid, index[0] + 1, index[1])) {
                    queue.add(new int[] { index[0] + 1, index[1] });
                    grid[index[0] + 1][index[1]] = 2;
                }

                if (isFresh(grid, index[0], index[1] - 1)) {
                    queue.add(new int[] { index[0], index[1] - 1 });
                    grid[index[0]][index[1] - 1] = 2;
                }

                if (isFresh(grid, index[0], index[1] + 1)) {
                    queue.add(new int[] { index[0], index[1] + 1 });
                     grid[index[0]][index[1] + 1] = 2;
                }
            }

            if (!queue.isEmpty()) {
                count += 1;
            }

        }
    }

    boolean isFresh(int[][] grid, int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return false;
        }

        if (grid[r][c] == 0 || grid[r][c] == 2) {
            return false;
        }

        return true;
    }
}
```