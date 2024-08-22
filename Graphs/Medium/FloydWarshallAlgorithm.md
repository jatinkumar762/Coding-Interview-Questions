* finds the shortest paths between all pairs of vertices in a weighted graph.
* It works for both directed and undirected graphs and can handle negative edge weights 
* although it does not work for graphs containing negative weight cycles.
* The algorithm uses a dynamic programming approach to build up the shortest paths by iteratively considering whether a path that goes through an intermediate vertex is shorter than the previously known paths.


### Algorithm Overview

* The algorithm works by considering each vertex as an intermediate vertex in the path between any two vertices.
* For each pair of vertices (i,j), it checks if a path from i to 𝑗 that goes through some vertex k is shorter than the direct path from i to j.
* This is repeated for every possible intermediate vertex.

### Steps of the Floyd-Warshall Algorithm

1. **Initialization**:
   - Create a distance matrix `dist[][]`, where `dist[i][j]` represents the shortest distance from vertex `i` to vertex `j`.
   - Initialize `dist[i][j]` to the weight of the edge between `i` and `j` if such an edge exists, or infinity $\infty$ if there is no direct edge. Set `dist[i][i]` to 0 for all vertices \(i\).

2. **Iterative Update**:
   - For each vertex \(k\) (considered as an intermediate vertex), update the distance matrix:
     - For every pair of vertices \(i\) and \(j\), update `dist[i][j]` as:
       $
       \text{dist}[i][j] = \min(\text{dist}[i][j], \text{dist}[i][k] + \text{dist}[k][j])
       $
     - This checks if the path from \(i\) to \(j\) through \(k\) is shorter than the current known path from \(i\) to \(j\).

3. **Final Result**:
   - After processing all vertices, the distance matrix `dist[][]` will contain the shortest paths between all pairs of vertices.

### Java Implementation

```java
import java.util.Arrays;

class FloydWarshall {
    final static int INF = 99999, V = 4;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];

        // Initialize the solution matrix as a copy of the input graph matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Update the distance matrix with the shortest paths
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { {0, 5, INF, 10},
                          {INF, 0, 3, INF},
                          {INF, INF, 0, 1},
                          {INF, INF, INF, 0} };

        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(graph);
    }
}
```

### Time Complexity

- The time complexity of the Floyd-Warshall algorithm is $(O(V^3))$, where $(V)$ is the number of vertices. 
- This cubic time complexity makes it less efficient than other algorithms like Dijkstra's when applied to large graphs, but it is more versatile as it computes all pairs shortest paths and can handle negative weights.

### Use Cases

- **All-Pairs Shortest Paths**: When you need to compute the shortest paths between all pairs of vertices, particularly in dense graphs.

- **Handling Negative Weights**: The algorithm can handle negative edge weights, but not negative weight cycles. If a negative weight cycle is detected (e.g., if `dist[i][i]` becomes negative for any vertex $(i)$, the graph contains such a cycle, and no solution exists.

- **Small to Medium-Sized Graphs**: Suitable for graphs where the number of vertices isn't too large due to its cubic time complexity.

The Floyd-Warshall algorithm is a robust and straightforward approach for solving the all-pairs shortest path problem, especially when negative weights are involved and the graph is not too large.