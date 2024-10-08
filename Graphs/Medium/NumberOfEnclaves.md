https://leetcode.com/problems/number-of-enclaves/description/

* multi source BFS

#### Approach-1 8ms
```java
class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    int Rows, Cols;

    public int numEnclaves(int[][] grid) {
        Rows = grid.length;
        Cols = grid[0].length;

        Queue<Node> queue = new LinkedList<>();

        // first found boundary sea land
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if ((i == 0 || i == Rows - 1 || j == 0 || j == Cols - 1) && grid[i][j] == 1) {
                    queue.add(new Node(i, j));
                    grid[i][j] = 2; //helps in identify which are not reachable
                    //also to track already visited
                }
            }
        }

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        while (queue.size() > 0) {
            Node node = queue.poll();
            for (int[] dir : directions) {
                int newR = node.r + dir[0];
                int newC = node.c + dir[1];
                if (newR >= 0 && newR < Rows && newC >= 0 && newC < Cols && grid[newR][newC] == 1) {
                    queue.add(new Node(newR, newC));
                    grid[newR][newC] = 2;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if (grid[i][j] == 1) {
                    count += 1;
                }
            }
        }

        return count;
    }
}
```

#### Approach-2 if we don't want to use 2 time grid traversal - 8ms

```java
class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    int Rows, Cols;

    public int numEnclaves(int[][] grid) {
        Rows = grid.length;
        Cols = grid[0].length;

        Queue<Node> queue = new LinkedList<>();

        int totalOne = 0;
        int reachAbleOne = 0;
        // first found boundary sea land
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if (grid[i][j] == 1) {
                    totalOne += 1;
                    if ((i == 0 || i == Rows - 1 || j == 0 || j == Cols - 1)) {
                        queue.add(new Node(i, j));
                        grid[i][j] = 2; 
                        reachAbleOne+=1;
                    }
                }
            }
        }

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        while (queue.size() > 0) {
            Node node = queue.poll();
            for (int[] dir : directions) {
                int newR = node.r + dir[0];
                int newC = node.c + dir[1];
                if (newR >= 0 && newR < Rows && newC >= 0 && newC < Cols && grid[newR][newC] == 1) {
                    queue.add(new Node(newR, newC));
                    grid[newR][newC] = 2;
                    reachAbleOne+=1;
                }
            }
        }

        return totalOne-reachAbleOne;
    }
}
```


#### Approach-3 DFS Solution - 9ms

* if i use Arrays.stream operation to count -> time will increase to 12ms

```java
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        //return Arrays.stream(grid).mapToInt(row -> Arrays.stream(row).sum()).sum();
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                   count+=1;
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                dfs(grid, x, y);
            }
        }
    }
}
```