

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

#### DFS Approach

```java
class Solution {

    int count = 0;
    int n;
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {

        n = isConnected.length;
        visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count += 1;
                dfs(isConnected, i);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int node){
        visited[node] = true;
        for(int j=0;j<n;j++){
            if(node!=j && !visited[j] && isConnected[node][j]==1){
                dfs(isConnected, j);
            }
        }
    }
}
```

#### BFS Approach

```java
class Solution {

    int count = 0;
    int n;
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {

        n = isConnected.length;
        visited = new boolean[n];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count += 1;
                visited[i] = true;
                queue.add(i);

                while(!queue.isEmpty()){
                    int node = queue.poll();

                    for(int j=0; j<n; j++){
                        if(!visited[j] && isConnected[node][j]==1){
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}
```
* Note - here DFS is faster than BFS by 1 ms
