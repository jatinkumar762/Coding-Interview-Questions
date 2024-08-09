https://leetcode.com/problems/01-matrix/description/

* multi source bfs

```java
class Node {
    int r;
    int c;
    int dist;

    Node(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}

class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int Row = mat.length;
        int Col = mat[0].length;
        boolean[][] visited = new boolean[Row][Col];
        int[][] dist = new int[Row][Col];

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Col; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[][] direction = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (queue.size() > 0) {

            Node node = queue.poll();
            dist[node.r][node.c] = node.dist;

            for (int[] dir : direction) {
                int newR = node.r + dir[0];
                int newC = node.c + dir[1];

                if (newR >= 0 && newR < Row && newC >= 0 && newC < Col && !visited[newR][newC]) {
                    queue.add(new Node(newR, newC, node.dist + 1));
                    visited[newR][newC] = true;
                }
            }

        }

        return dist;
    }
}
```