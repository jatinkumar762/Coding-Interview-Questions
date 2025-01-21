https://leetcode.com/problems/rotting-oranges/description/


### Approach-1

```java
class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int ROWS = grid.length;
        int COLS = grid[0].length;

        boolean fresh = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh = true;
                }
            }
        }

        if (!fresh) {
            return 0;
        }

        int time = -1, size;

        Pair<Integer, Integer> p;

        int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {

            time++;

            size = queue.size();

            for (int i = 0; i < size; i++) {
                p = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int newX = p.getKey() + dir[j][0];
                    int newY = p.getValue() + dir[j][1];

                    if (isFresh(grid, newX, newY, ROWS, COLS)) {
                        queue.add(new Pair(newX, newY));
                        grid[newX][newY] = 2;
                    }
                }
            }

        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

    private boolean isFresh(int[][] grid, int r, int c, int ROWS, int COLS) {
        if (r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] == 1) {
            return true;
        }
        return false;
    }
}
```

---

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

#### little optimized of above, we can keep count of fresh

```java
class Solution {
    int R;
    int C;
    int count;
    Queue<int[]> queue = new LinkedList<>();
    int fresh;

    public int orangesRotting(int[][] grid) {

        R = grid.length;
        C = grid[0].length;
        count = 0;
        fresh = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    fresh += 1;
                }
            }
        }

        if (fresh > 0) {
            bfs(grid);
        }

        return fresh == 0 ? count : -1;
    }

    void bfs(int[][] grid) {

        while (!queue.isEmpty()) {

            boolean foundFresh = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] index = queue.poll();
                if (isFresh(grid, index[0] - 1, index[1])) {
                    queue.add(new int[] { index[0] - 1, index[1] });
                    grid[index[0] - 1][index[1]] = 2;
                    fresh -= 1;
                    foundFresh = true;
                }

                if (isFresh(grid, index[0] + 1, index[1])) {
                    queue.add(new int[] { index[0] + 1, index[1] });
                    grid[index[0] + 1][index[1]] = 2;
                    fresh -= 1;
                    foundFresh = true;
                }

                if (isFresh(grid, index[0], index[1] - 1)) {
                    queue.add(new int[] { index[0], index[1] - 1 });
                    grid[index[0]][index[1] - 1] = 2;
                    fresh -= 1;
                    foundFresh = true;
                }

                if (isFresh(grid, index[0], index[1] + 1)) {
                    queue.add(new int[] { index[0], index[1] + 1 });
                    grid[index[0]][index[1] + 1] = 2;
                    fresh -= 1;
                    foundFresh = true;
                }
            }

            if (foundFresh) {
                count += 1;
            }

        }
    }

    boolean isFresh(int[][] grid, int r, int c) {
        if (r >= 0 && r < R && c >= 0 && c < C && grid[r][c] == 1) {
            return true;
        }
        return false;
    }
}
```