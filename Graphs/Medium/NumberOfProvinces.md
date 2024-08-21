* DFS is faster than all - 1ms
* BFS and Disjoint set union - 2ms

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


#### If 2 matrix represented by List

https://www.geeksforgeeks.org/problems/number-of-provinces/1

```java
class Solution {
    
    static int count;
    static int N;
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        N = V;
        count = 0;
        
        for(int i=0;i<N;i++){
            if(!visited[i]){
                count+=1;
                dfs(adj, i, visited);
            }
        }
        return count;
    }
    
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited){
        
        if(visited[node]){
            return;
        }
        
        visited[node] = true;
        
        for(int j=0;j<N;j++){
            if(adj.get(node).get(j)==1 && visited[j]==false){
                dfs(adj, j, visited);
            }
        } 
        
    }
}
```


## Disjoint Set Union by size

* will be helpful, when list of edges given to us

```java
class Solution {
    int[] parent;
    int[] size;

    private int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private void union(int parentX, int parentY) {

        // int parentX = find(x);
        // int parentY = find(y);

        // if(parentX!=parentY){
        if (size[parentX] >= size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
        // }
    }

    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;
        parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        size = new int[V];
        Arrays.fill(size, 1);

        int total = V;

        for (int i = 0; i < V; i++) {
            // int parentX = find(i);
            // wrong here, bcz even if parent updated of i, after merge with j
            // will not reflect in another j, latest paret of i
            for (int j = 0; j < V; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    int parentX = find(i);
                    int parentY = find(j);
                    if (parentX != parentY) {
                        total -= 1;
                        union(parentX, parentY);
                    }

                    //to avoid re-compute this edge
                    isConnected[j][i] = 0;
                }
            }
        }

        return total;
    }
}
```

**little change - modified union**

```java
class Solution {
    int[] parent;
    int[] size;

    private int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    private int union(int x, int y) {

        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return 0;
        }

        if (size[parentX] >= size[parentY]) {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        } else {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        }
        return 1;
    }

    public int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;
        parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        size = new int[V];
        Arrays.fill(size, 1);

        int total = V;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    if (union(i, j) == 1) {
                        total -= 1;
                    }
                    // to avoid re-compute this edge
                    isConnected[j][i] = 0;
                }
            }
        }

        return total;
    }
}
```