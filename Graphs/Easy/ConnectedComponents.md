https://takeuforward.org/graph/connected-components-in-graphs/

## Problem: Connected Components in an Undirected Graph

- https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/

- https://neetcode.io/problems/count-connected-components (https://www.youtube.com/watch?v=8f1XPm4WOUc)

- https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

#### Approach-1: USing DFS/BFS

```java
class Solution {

    int V;
    ArrayList<ArrayList<Integer>> adjList;
		//we can use map also
		//Map<Integer, ArrayList<Integer>>
    boolean[] visited;
    int count;

    public int countComponents(int n, int[][] edges) {

        this.V = n;

        adjList = new ArrayList<>();

				//0 <= ai <= bi < n
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        visited = new boolean[n];
        count = 0;

        // for (int i : adjList.keySet()) {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, adjList);
            }
        }

        return count;
    }

    void dfs(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {

        if (visited[v]) {
            return;
        }

        visited[v] = true;

        for (Integer nbr : adjList.get(v)) {
            if (!visited[nbr]) {
                dfs(nbr, visited, adjList);
            }
        }
    }
}
```

#### Approach-2: Using Disjoint Set Union

* similar problem - https://leetcode.com/problems/number-of-provinces/description/
* [Solution](../Medium/NumberOfProvinces.md)

```java

```