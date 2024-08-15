https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

https://www.youtube.com/watch?v=YnxUdAO7TAo

* If we want to find a possible path, DFS will be more efficient. Because DFS will return a possible path if found, while it may not the shortest path.

* BFS will try every possible path at the same time.

* If we want to find the shortest of all possible paths, BFS is more efficient. It's impossible for DFS to determine which is the shortest before trying all possible paths.

#### Approach-1 BFS Solution
```java
class Solution {
    int Rows, Cols;

    public int shortestPathBinaryMatrix(int[][] grid) {

        Rows = grid.length;
        Cols = grid[0].length;

        if (grid[0][0] != 0 || grid[Rows - 1][Cols - 1] != 0) {
            return -1;
        }

        int[][] dist = new int[Rows][Cols];
        boolean[][] visited = new boolean[Rows][Cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        dist[0][0] = 1;
        visited[0][0] = true;

        int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == Rows - 1 && curr[1] == Cols - 1) {
                return dist[Rows - 1][Cols - 1];
            }

            for (int[] dir : directions) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                if (newX >= 0 && newX < Rows && newY >= 0 && newY < Cols && grid[newX][newY] == 0
                        && !visited[newX][newY]) {
                    queue.add(new int[] { newX, newY });
                    dist[newX][newY] = dist[curr[0]][curr[1]] + 1;
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }
}
```

#### another bfs approach - taking same time

```java
class Solution {
    int Rows, Cols;

    public int shortestPathBinaryMatrix(int[][] grid) {

        Rows = grid.length;
        Cols = grid[0].length;

        if (grid[0][0] != 0 || grid[Rows - 1][Cols - 1] != 0) {
            return -1;
        }

        boolean[][] visited = new boolean[Rows][Cols];
        int dist = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;

        int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        while (!queue.isEmpty()) {

            int size = queue.size();
            dist += 1;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == Rows - 1 && curr[1] == Cols - 1) {
                    return dist;
                }

                for (int[] dir : directions) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    if (newX >= 0 && newX < Rows && newY >= 0 && newY < Cols && grid[newX][newY] == 0
                            && !visited[newX][newY]) {
                        queue.add(new int[] { newX, newY });
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        return -1;
    }
}
```

Time Complexity: $O(Rows*Cols)$
