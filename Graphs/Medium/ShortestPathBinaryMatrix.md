https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

https://www.youtube.com/watch?v=YnxUdAO7TAo

```java
class Solution {
    int Rows, Cols;

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] != 0) {
            return -1;
        }

        Rows = grid.length;
        Cols = grid[0].length;

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

        if(!visited[Rows - 1][Cols - 1]){
            return -1;
        }

        return dist[Rows - 1][Cols - 1];
    }
}
```