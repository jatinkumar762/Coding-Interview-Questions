https://leetcode.com/problems/flood-fill/description/

#### Approach-1 Using BFS

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
    int Rows, Cols, currentColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Rows = image.length;
        Cols = image[0].length;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sr, sc));
        currentColor = image[sr][sc];
        image[sr][sc] = color;

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        while (queue.size() > 0) {
            Node node = queue.poll();
            for (int[] dir : directions) {
                int newR = node.r + dir[0];
                int newC = node.c + dir[1];
                if (newR >= 0 && newR < Rows && newC >= 0 && newC < Cols && image[newR][newC] == currentColor
                        && image[newR][newC] != color) {
                    queue.add(new Node(newR, newC));
                    image[newR][newC] = color;
                }
            }
        }
        return image;
    }
}
```


#### Recursive Solution

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
```