https://www.geeksforgeeks.org/implementation-of-dfs-using-adjacency-matrix/


#### Recursive approach

```java
import java.io.*;

class GFG {
	// adjacency matrix
	static int[][] adj;

	// function to add edge to the graph
	static void addEdge(int x, int y)
	{
		adj[x][y] = 1;
		adj[y][x] = 1;
	}

	// function to perform DFS on the graph
	static void dfs(int start, boolean[] visited)
	{

		// Print the current node
		System.out.print(start + " ");

		// Set current node as visited
		visited[start] = true;

		// For every node of the graph
		for (int i = 0; i < adj[start].length; i++) {

			// If some node is adjacent to the current node
			// and it has not already been visited
			if (adj[start][i] == 1 && (!visited[i])) {
				dfs(i, visited);
			}
		}
	}

	public static void main(String[] args)
	{
		// number of vertices
		int v = 5;

		// number of edges
		int e = 4;

		// adjacency matrix
		adj = new int[v][v];

		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(0, 3);
		addEdge(0, 4);

		// Visited vector to so that
		// a vertex is not visited more than once
		// Initializing the vector to false as no
		// vertex is visited at the beginning
		boolean[] visited = new boolean[v];

		// Perform DFS
		dfs(0, visited);
	}
}
```