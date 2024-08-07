

#### Wrong Approach - Incorrect Code

Input
isConnected =
[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]

Output
2
Expected
1

```java
class Solution {

    int count = 0;
    int n;
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {

        n = isConnected.length;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count += 1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && isConnected[i][j] == 1) {
                        visited[j] = true;
                    }
                }
            }
        }
        return count;
    }
}
```